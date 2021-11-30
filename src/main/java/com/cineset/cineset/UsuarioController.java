package com.cineset.cineset;

import java.util.List;
import java.util.Map;

import com.model.Usuario;
import com.model.UsuarioService;
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
public class UsuarioController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/usuario")
    public String login(Model model) {
        model.addAttribute("user", new Usuario());
        return "login";
    }

    @PostMapping("/usuario")
    public String postUsuario(@ModelAttribute Usuario user, Model model) {
        UsuarioService uService = context.getBean(UsuarioService.class);
        uService.insertUsuario(user);
        Map<String, Object> infos = uService.selectInfo(user.getEMAIL(), user.getSENHA());
        return "redirect:/profile/" + infos.get("ID");
    }

    @GetMapping("/profile/{ID}")
    public String profile(@PathVariable("ID") int ID, Model model) {
        UsuarioService uService = context.getBean(UsuarioService.class);
        Map<String, Object> map = uService.selectUsuario(ID);
        model.addAttribute("NOMEUSUARIO", map.get("NOMEUSUARIO"));
        return "profile";
    }

    @GetMapping("/usuarios")
    public String listaUsuarios(Model model) {
        UsuarioService uService = context.getBean(UsuarioService.class);
        List<Map<String, Object>> usuarios = uService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "profile";
    }

    @PostMapping("/delete/usuarios/{ID}")
    public String apagarUsuario(@PathVariable("ID") int ID) {
        UsuarioService uService = context.getBean(UsuarioService.class);
        uService.deleteUsuario(ID);
        return "redirect:/usuarios";
    }
}
