package com.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//import java.util.Map;

@Repository
public class FilmesDAO {

    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void insertfilme(Filmes filmes) {
        String sql = "INSERT INTO Filmes(TITULO, GENEROFILME, DIRETOR, SINOPSE, BIRTHYEAR)" + "VALUES(?,?,?,?,?)";

        Object[] object = new Object[5];
        object[0] = filmes.getTITULO();
        object[1] = filmes.getGENEROFILME();
        object[2] = filmes.getDIRETOR();
        object[3] = filmes.getSINOPSE();
        object[4] = filmes.getBIRTHYEAR();

        jdbc.update(sql, object);
    }

    // public Map<String, Object> selectfilme(int ID) {
    // String sql = "SELECT * FROM Filmes WHERE Filmes.ID = ?";
    // Object[] object = new Object[1];
    // object[0] = ID;
    // return jdbc.queryForMap(sql, object);
    // }
}
