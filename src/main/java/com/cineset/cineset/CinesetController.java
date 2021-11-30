package com.cineset.cineset;

import java.util.List;
import java.util.Map;

import com.model.Diretor;
import com.model.DiretorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CinesetController {

    @Autowired
    private ApplicationContext context;

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
    public String addmovie(Model model) {
        DiretorService dService = context.getBean(DiretorService.class);
        List<Map<String, Object>> diretores = dService.select();
        model.addAttribute("diretores", diretores);
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

    @GetMapping("/edit")
    public String edit() {
        return "edit";
    }

    @GetMapping("/addDiretor")
    public String addDiretor(Model model) {
        model.addAttribute("diretor", new Diretor());
        return "addDiretor";
    }

}
