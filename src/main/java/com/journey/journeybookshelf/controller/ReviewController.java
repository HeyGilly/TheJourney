package com.journey.journeybookshelf.controller;

import com.journey.journeybookshelf.models.Review;
import com.journey.journeybookshelf.models.User;
import com.journey.journeybookshelf.repository.ReviewRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

//    @GetMapping("/review/{id}")
//    public String showProfile(Model model){
//        return "main/reviews";
//    }

    @PostMapping("/review/{id}")
    public String updateReview(@ModelAttribute Review review, @PathVariable long id,Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        Review findReview = reviewDao.findById(id);
        findReview.setReviewTitle(review.getReviewTitle());
        findReview.setReviewBody(review.getReviewBody());
        findReview.setRating(review.getRating());
        reviewDao.save(findReview);
        return "redirect:/main";
    }

}
