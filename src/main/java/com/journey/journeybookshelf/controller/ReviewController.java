package com.journey.journeybookshelf.controller;

import com.journey.journeybookshelf.models.Review;
import com.journey.journeybookshelf.models.User;
import com.journey.journeybookshelf.repository.ReviewRepository;
import com.journey.journeybookshelf.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewController {

    private final ReviewRepository reviewDao;
    private final UserRepository userDao;

    public ReviewController(ReviewRepository reviewDao, UserRepository userDao) {
        this.reviewDao = reviewDao;
        this.userDao = userDao;
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

    @PostMapping("/review/delete")
    public String deleteReview(@RequestParam(name= "deleteReview") long id) {
        reviewDao.deleteById(id);
        return "redirect:/reviews";
    }

}
