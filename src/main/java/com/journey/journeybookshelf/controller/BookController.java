package com.journey.journeybookshelf.controller;

import com.journey.journeybookshelf.models.Review;
import com.journey.journeybookshelf.models.User;
import com.journey.journeybookshelf.repository.AllBookTableRepository;
import com.journey.journeybookshelf.repository.ReviewRepository;
import com.journey.journeybookshelf.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    private final AllBookTableRepository booksDao;
    private final ReviewRepository reviewDao;
    private final UserRepository userDao;

    public BookController(AllBookTableRepository booksDao, ReviewRepository reviewDao, UserRepository userDao){
        this.booksDao = booksDao;
        this.reviewDao = reviewDao;
        this.userDao = userDao;
    }

//    @RequestMapping("/main")
//    public List<AllBookTable> viewHomePage(Model model, @Param("keyword") String keyword) {
//        List<AllBookTable> BOOKS = booksDao.search(keyword);
//        model.addAttribute("BOOKS", BOOKS);
//        return BOOKS;
//    }

    @GetMapping("/main")
    public ModelAndView getAllBooks() {
        ModelAndView book = new ModelAndView("main/main");
        book.addObject("BOOKS", booksDao.findAll());
        return book;
    }

    //review form
    @GetMapping("/reviewForm")
    public String reviewsForm(Model model){
        model.addAttribute("review", new Review());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",user);
        return "main/reviewForm";
    }
    @PostMapping("/reviewForm")
    public String reviewsSubmit(@ModelAttribute Review review, Model model){
        // This is what was added to get it to work
        // needed to save the user with the userDoa
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principal;
        review.setUser(user);
        Review newReview = reviewDao.save(review);
        // Calling the new variable to be added
        model.addAttribute("review", newReview);
        return "main/profile";
    }
    //review form

}
