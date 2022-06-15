package com.journey.journeybookshelf.controller;


import com.journey.journeybookshelf.models.User;
import com.journey.journeybookshelf.repository.ReviewRepository;
import com.journey.journeybookshelf.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserRepository userDao;
    private ReviewRepository reviewDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder,ReviewRepository reviewDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.reviewDao = reviewDao;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);

        userDao.save(user);
        return "redirect:/login";
    }
//    @GetMapping("/profile")
//    public String profile(){
//        return "users/profile";
//    }

    @GetMapping("/profile")
    public String profile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("reviews", reviewDao.findAllByUser(user));
        model.addAttribute("user",user);
        model.addAttribute("loggedInUser",user);
        return "users/profile";
    }

    @GetMapping("/profile/{username}")
    public String usersProfile(@PathVariable String username, Model model){
        User user = userDao.findByUsername(username);
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        model.addAttribute("reviews", reviewDao.findAllByUser(user));
        model.addAttribute("user",user);
        model.addAttribute("loggedInUser",loggedInUser);
        return "users/profile";
    }

    @PostMapping("/profile/{username}")
    public String updateProfile(@ModelAttribute User userModel){
        User user = userDao.findByUsername(userModel.getUsername());
        String hash = passwordEncoder.encode(userModel.getPassword());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setUsername(userModel.getUsername());
        user.setPassword(hash);
        user.setBio(userModel.getBio());
        user.setCity(userModel.getCity());
        user.setState(userModel.getState());
        userDao.save(user);
        return "redirect:/profile/{username}";
    }


//    @PostMapping("/profile/delete")
//    public String deleteProfile(@RequestParam(name= "deleteProfile") long id) {
//        userDao.deleteById(id);
//        return "redirect:/register";
//    }
}