package com.egor.blog.controller;
import com.egor.blog.domain.Post;
import com.egor.blog.domain.User;
import com.egor.blog.repo.PostRepository;
import com.egor.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addPost(@RequestParam String title, @RequestParam String text, Map<String, Object> model) {
        Post post = new Post(title,text);
        postRepository.save(post);
        return "redirect:/";

    }
    @GetMapping("/create")
    public String getCreatePage(Map<String, Object> model) {
                return "create";
    }
}
