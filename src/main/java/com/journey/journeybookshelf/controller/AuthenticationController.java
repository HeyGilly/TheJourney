package com.journey.journeybookshelf.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthenticationController {

    // Login
    //
    @GetMapping("/login")
    public String loginForm(){
        return "users/login";
    }

    @GetMapping("/error")
    public String errorForm() { return "users/login";}


}
