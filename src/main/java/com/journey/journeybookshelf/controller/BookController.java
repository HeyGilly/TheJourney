package com.journey.journeybookshelf.controller;

import com.journey.journeybookshelf.models.AllBookTable;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView getAllBooks(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",user);
        ModelAndView book = new ModelAndView("main/main");
        book.addObject("BOOKS", booksDao.findAll());
        return book;
    }




    @GetMapping("/books/{id}")
    public String showBook(@PathVariable long id, Model model, Review review){
        AllBookTable book = booksDao.findById(id).get();
        model.addAttribute("book", book);
        List<Review> reviewsList = reviewDao.findAllByallBookTable(book);
        model.addAttribute("reviewsList", reviewsList);
        return "main/single-book";
    }





    //    Saves book and maps to api/books <--- singlePage
    @PostMapping("/api/books")
    public String createBook(@ModelAttribute AllBookTable book, Model model){
        booksDao.save(book);
        model.addAttribute("book", book);
        System.out.println(book);
        return "main/single-book";
    }
}
