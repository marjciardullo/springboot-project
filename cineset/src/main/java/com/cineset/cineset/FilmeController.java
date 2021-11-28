package com.cineset.cineset;

//import java.util.Map;

import com.model.Filmes;
import com.model.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@ComponentScan("com.model")
public class FilmeController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/filmes")
    public String login(Model model) {
        model.addAttribute("film", new Filmes());
        return "mymovies";
    }

    @PostMapping("/filmes")
    public String postUsuario(@ModelAttribute Filmes film, Model model) {
        FilmesService fService = context.getBean(FilmesService.class);
        fService.insertFilme(film);
        return "profile";
    }
}