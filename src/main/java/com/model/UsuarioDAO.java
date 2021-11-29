package com.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//import java.util.List;
import java.util.Map;

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
        String sql = "INSERT INTO Usuario(NOMEUSUARIO, EMAIL, SENHA)" + " VALUES(?,?,?)";

        Object[] object = new Object[3];
        object[0] = usuario.getNOMEUSUARIO();
        object[1] = usuario.getEMAIL();
        object[2] = usuario.getSENHA();

        jdbc.update(sql, object);
    }

    public Map<String, Object> selectUsuario(int ID) {
        String sql = "SELECT * FROM Usuario WHERE Usuario.ID = ?";
        Object[] obj = new Object[1];
        obj[0] = ID;
        return jdbc.queryForMap(sql, obj);
    }
}
