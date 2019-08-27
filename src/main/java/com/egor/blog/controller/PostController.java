package com.egor.blog.controller;

import com.egor.blog.domain.Post;
import com.egor.blog.domain.User;
import com.egor.blog.repo.PostRepository;
import com.egor.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostService postService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/{slug}")
    public String getPost(@PathVariable String slug, Model model) {
        Post post = postRepository.findBySlug(slug);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/{slug}/edit")
    public String editPost(
            @AuthenticationPrincipal User user,
            @PathVariable String slug,
            Model model) {
        Post post = postRepository.findBySlug(slug);
        User author = post.getAuthor();
        model.addAttribute("post", post);
        if (user.getId().equals(author.getId())) {
            return "create";
        }
        model.addAttribute("message", "Вы не моежете редактировать данную запись,т.к. не являетесь ее автором");
        return "post";
    }

    @GetMapping("/create")
    public String getCreatePage(Map<String, Object> model) {
        return "create";
    }

    @PostMapping({"/create", "/{slug}/edit"})
    public String savePost(
            @AuthenticationPrincipal User user,
            @Valid Post post,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        post.setAuthor(user);
        String slug = post.getSlug();
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("post", post);
            return "/create";
        } else {
            slug = postService.savePost(post, file);
        }
        return "redirect:/post/" + slug;
    }
}
