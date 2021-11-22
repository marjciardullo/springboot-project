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

    public void insertfilme(Filmes filme) {
        String sql = "INSERT INTO filme(TITULO, GENERO, DIRETOR, IMAGEM_LINK, SINOPSE, ANO)" + "VALUES(?,?,?,?,?,?)";

        Object[] object = new Object[6];
        object[0] = filme.getTITULO();
        object[1] = filme.getGENERO();
        object[2] = filme.getDIRETOR();
        object[3] = filme.getIMAGEM_LINK();
        object[4] = filme.getSINOPSE();
        object[5] = filme.getANO();

        jdbc.update(sql, object);
    }

    // public Map<String, Object> selectfilme(int ID) {
    // String sql = "SELECT * FROM Filmes WHERE Filmes.ID = ?";
    // Object[] object = new Object[1];
    // object[0] = ID;
    // return jdbc.queryForMap(sql, object);
    // }
}
