package com.egor.blog.controller;

import com.egor.blog.domain.Post;
import com.egor.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    PostRepository postRepository;


    @GetMapping("/")
    public String getPosts() {
        return "redirect:/posts";
    }
    @GetMapping("/posts")
    public String getIndex(Map<String, Object> model) {
        Iterable<Post> posts = postRepository.findAllByOrderByIdDesc();
        model.put("posts", posts);
        return "posts";

    }

}
