package com.egor.blog.controller;
import com.egor.blog.domain.User;
import com.egor.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "index";
    }
    @GetMapping("/create")
    public String getIndex(Map<String, Object> model) {
                return "create";
    }

    @PostMapping("/create")
    public String addUser (@RequestParam String username, @RequestParam String pass, Map<String, Object> model) {
                return "redirect:/";
    }
}
