package com.model;

import java.util.List;
import java.util.Map;

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
        String sql = "INSERT INTO Filmes(TITULO, DIRETOR, BIRTHYEAR, SINOPSE)" + "VALUES(?,?,?,?)";

        Object[] object = new Object[4];
        object[0] = filmes.getTITULO();
        object[1] = filmes.getDIRETOR();
        object[2] = filmes.getBIRTHYEAR();
        object[3] = filmes.getSINOPSE();

        jdbc.update(sql, object);
    }

    public Map<String, Object> selectfilme(int IDFILME) {
        String sql = "SELECT * FROM Filmes WHERE Filmes.IDFILME = ?";
        Object[] object = new Object[1];
        object[0] = IDFILME;
        return jdbc.queryForMap(sql, object);
    }

    public List<Map<String, Object>> getFilmes() {
        String sql = "SELECT * FROM Filmes";
        List<Map<String, Object>> filmes = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return filmes;
    }

    public void deleteFilme(int IDFILME) {
        String sql = "DELETE FROM Filmes WHERE IDFILME = ?";
        Object[] obj = new Object[1];
        obj[0] = IDFILME;
        jdbc.update(sql, obj);
    }

    public void updateFilme(int IDFILME, Filmes filme) {
        String sql = "UPDATE Filmes SET TITULO = ?, DIRETOR = ?, BIRTHYEAR = ?, SINOPSE = ? WHERE IDFILME = ?";
        Object[] object = new Object[5];
        object[0] = filme.getTITULO();
        object[1] = filme.getDIRETOR();
        object[2] = filme.getBIRTHYEAR();
        object[3] = filme.getSINOPSE();
        object[4] = IDFILME;
        jdbc.update(sql, object);
    }
}
