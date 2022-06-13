package com.journey.journeybookshelf.controller;

import com.journey.journeybookshelf.repo.AllBookTableRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    private final AllBookTableRepo booksDao;

    public BookController(AllBookTableRepo booksDao){
        this.booksDao = booksDao;
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

}
