package com.cineset.cineset;

import java.util.Map;
import java.io.Console;
import java.util.List;
//import java.util.Map;

import com.model.DiretorService;
import com.model.FilmeDTO;
import com.model.Filmes;
import com.model.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        DiretorService dService = context.getBean(DiretorService.class);
        List<Map<String, Object>> diretores = dService.select();
        model.addAttribute("diretores", diretores);
        model.addAttribute("film", new FilmeDTO());
        return "addmovie";
    }

    @PostMapping("/filmes")
    public String postUsuario(@ModelAttribute FilmeDTO film, Model model) {
        FilmesService fService = context.getBean(FilmesService.class);
        fService.insertFilme(film);
        return "redirect:/filme";
    }

    @GetMapping("/filmes/{IDFILME}")
    public String getFilme(@PathVariable("IDFILME") int IDFILME, Model model) {
        FilmesService fService = context.getBean(FilmesService.class);
        Map<String, Object> map = fService.selectfilme(IDFILME);
        model.addAttribute("TITULO", map.get("TITULO"));
        model.addAttribute("BIRTHYEAR", map.get("BIRTHYEAR"));
        model.addAttribute("DIRETOR", map.get("DIRETOR"));
        model.addAttribute("SINOPSE", map.get("SINOPSE"));
        return "mymovies";
    }

    @GetMapping("/filme")
    public String listaFilmes(Model model) {
        FilmesService fService = context.getBean(FilmesService.class);
        List<Map<String, Object>> filmes = fService.getFilmes();
        model.addAttribute("filmes", filmes);
        return "mymovies";
    }

    @PostMapping("/delete/filme/{IDFILME}")
    public String apagarFilme(@PathVariable("IDFILME") int IDFILME) {
        FilmesService fService = context.getBean(FilmesService.class);
        fService.deleteFilme(IDFILME);
        return "redirect:/filme";
    }

    @GetMapping("/update/{IDFILME}")
    public String updateFilme(@PathVariable("IDFILME") int IDFILME, Model model) {
        FilmesService fService = context.getBean(FilmesService.class);
        Map<String, Object> info = fService.selectfilme(IDFILME);
        Filmes film = new Filmes(IDFILME, info.get("TITULO").toString(), info.get("IDDIRETOR").toString(),
                info.get("BIRTHYEAR").toString(), info.get("SINOPSE").toString());
        model.addAttribute("film", film);
        model.addAttribute("IDFILME", IDFILME);

        DiretorService dService = context.getBean(DiretorService.class);
        List<Map<String, Object>> diretores = dService.select();
        model.addAttribute("diretores", diretores);

        return "editmovie";
    }

    @PostMapping("/update/{IDFILME}")
    public String updateFilme(@PathVariable("IDFILME") int IDFILME,
            Model model,
            @ModelAttribute FilmeDTO film) {
        FilmesService filmesService = context.getBean(FilmesService.class);
        filmesService.updateFilme(IDFILME, film);
        return "redirect:/filme";
    }
}