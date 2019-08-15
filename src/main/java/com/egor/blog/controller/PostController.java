package com.egor.blog.controller;

import com.egor.blog.domain.Post;
import com.egor.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping ("/{slug}")
    public String getPost(@PathVariable String slug, Model model) {

        Post post = postRepository.findBySlug(slug);
        model.addAttribute("title",post.getTitle());
        return "post";
    }
}
