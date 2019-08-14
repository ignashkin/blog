package com.egor.blog.controller;

import com.egor.blog.domain.Post;
import com.egor.blog.domain.User;
import com.egor.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    PostRepository postRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String getIndex(Map<String, Object> model) {
        Iterable<Post> posts = postRepository.findAll();
        model.put("posts", posts);
        return "index";

    }

    @PostMapping("/create")
    public String addPost(
            @AuthenticationPrincipal User user,
            @Valid Post post,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        post.setAuthor(user);
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("post",post);
            model.addAttribute("message", "Пост опубликован");
            return "/create";
        } else {


            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadPath + "/" + resultFilename));
                post.setFilename(resultFilename);
            }
            postRepository.save(post);
        }
//        model.addAttribute("message",messages);
        return "redirect:/";
    }



    @GetMapping("/create")
    public String getCreatePage(Map<String, Object> model) {
        return "create";
    }
}
