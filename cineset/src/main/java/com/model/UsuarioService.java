package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioDAO userDao;

    public void inserirtUsuario(Usuario user) {
        userDao.insertUsuario(user);
    }
}