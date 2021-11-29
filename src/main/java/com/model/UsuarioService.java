package com.model;

//import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioDAO userDao;

    public void insertUsuario(Usuario user) {
        userDao.insertUsuario(user);
    }

    public Map<String, Object> selectUsuario(int ID) {
        return userDao.selectUsuario(ID);
    }
}
