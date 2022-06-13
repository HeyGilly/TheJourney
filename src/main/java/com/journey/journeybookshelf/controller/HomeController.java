package com.journey.journeybookshelf.controller;

import com.journey.journeybookshelf.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Controllers are used to making or building a web controller.
@Controller
public class HomeController {
    private final UserRepository userRepo;

    public HomeController(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    // Index Page
    @GetMapping("/")
    public String home(){ return "home/index";}


    // About Page
    // Nothing special on this page, just the introduction to all members.
    @GetMapping("/about")
    public String about(){ return "home/about";}
}
