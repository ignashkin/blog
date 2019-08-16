package com.egor.blog.controller;

import com.egor.blog.domain.Post;
import com.egor.blog.domain.User;
import com.egor.blog.repo.PostRepository;
import com.egor.blog.service.SlugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    SlugService slugService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping ("/{slug}")
    public String getPost(@PathVariable String slug, Model model) {
        Post post = postRepository.findBySlug(slug);
        model.addAttribute("post",post);
        return "post";
    }


    @GetMapping("/create")
    public String getCreatePage(Map<String, Object> model) {
        return "create";
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
            model.addAttribute("post", post);
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
            String slug = slugService.makeSlug(post.getTitle()) + "-" + post.getId();
            post.setSlug(slug);
            postRepository.save(post);
        }
        return "redirect:/post/"+post.getSlug();
    }
}
