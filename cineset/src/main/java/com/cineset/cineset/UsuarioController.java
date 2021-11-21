package com.cineset.cineset;

import com.model.Usuario;
import com.model.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@ComponentScan("com.model")
public class UsuarioController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/usuario")
    public String formUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formUsuario";
    }

    @PostMapping("/usuario")
    public String postUsuario(@ModelAttribute Usuario user, Model model) {
        UsuarioService uService = context.getBean(UsuarioService.class);
        uService.inserirtUsuario(user);
        return "success!!";
    }
}
