package com.journey.journeybookshelf.controller;

import com.journey.journeybookshelf.models.User;
import com.journey.journeybookshelf.repository.ReviewRepository;
import com.journey.journeybookshelf.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Controllers are used to making or building a web controller.
@Controller
public class HomeController {
    private final UserRepository userRepo;
    private final ReviewRepository reviewDao;

    public HomeController(UserRepository userRepo, ReviewRepository reviewDao){
        this.userRepo = userRepo;
        this.reviewDao = reviewDao;
    }

    // Index Page
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("reviews", reviewDao.findAll());
        return "home/index";}


    // About Page
    // Nothing special on this page, just the introduction to all members.
    @GetMapping("/about")
    public String about(){ return "home/about";}
}
