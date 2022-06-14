package com.journey.journeybookshelf.controller;

import com.journey.journeybookshelf.models.User;
import com.journey.journeybookshelf.repository.ReviewRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

    private final ReviewRepository reviewDao;

    public ReviewController(ReviewRepository reviewDao) {
        this.reviewDao = reviewDao;
    }

    @GetMapping("/reviews")
    public String allReviews(Model model){
        model.addAttribute("reviews", reviewDao.findAll());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "main/reviews";
    }

}
