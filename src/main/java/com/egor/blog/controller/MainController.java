package com.egor.blog.controller;

import com.egor.blog.domain.Post;
import com.egor.blog.domain.User;
import com.egor.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/")
    public String getIndex(Map<String, Object> model) {
        Iterable<Post> posts = postRepository.findAll();
        model.put("posts", posts);
        return "index";

    }

    @PostMapping("/create")
    public String addPost(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) {
        Post post = new Post(title,text, tag, user);
        postRepository.save(post);
        return "redirect:/";

    }
    @GetMapping("/create")
    public String getCreatePage(Map<String, Object> model) {
                return "create";
    }
}
