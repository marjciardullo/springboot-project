package com.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {

    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void insertUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario(NOME, EMAIL, SENHA)" + "VALUES(?,?,?)";

        Object[] object = new Object[3];
        object[0] = usuario.getNOME();
        object[1] = usuario.getEMAIL();
        object[2] = usuario.getSENHA();

        jdbc.update(sql, object);
    }
}
