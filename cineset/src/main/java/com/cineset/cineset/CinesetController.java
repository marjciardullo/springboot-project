package com.cineset.cineset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CinesetController {

    @GetMapping("/")
    public String homepage() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/addmovie")
    public String addmovie() {
        return "addmovie";
    }

    @GetMapping("/mymovies")
    public String mymovies() {
        return "mymovies";
    }

    @GetMapping("/editmovie")
    public String editmovie() {
        return "editmovie";
    }

}
