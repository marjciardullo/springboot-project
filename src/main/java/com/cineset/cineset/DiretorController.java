package com.cineset.cineset;

import java.util.List;
import java.util.Map;

import com.model.Diretor;
import com.model.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@ComponentScan("com.model")
public class DiretorController {

    @Autowired
    private ApplicationContext context;

    @PostMapping("/addDiretor")
    public String postDiretor(@ModelAttribute Diretor diretor, Model model) {
        DiretorService dService = context.getBean(DiretorService.class);
        dService.insert(diretor);
        return "redirect:/addmovie/";
    }

}