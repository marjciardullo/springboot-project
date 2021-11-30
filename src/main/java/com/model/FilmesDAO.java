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

    public void insertfilme(FilmeDTO filmes) {
        String sql = "INSERT INTO Filmes(TITULO, BIRTHYEAR, SINOPSE)" + " VALUES(?,?,?)";
        Object[] object = new Object[3];
        object[0] = filmes.getTITULO();
        // object[1] = filmes.getIDDIRETOR();
        object[1] = filmes.getBIRTHYEAR();
        object[2] = filmes.getSINOPSE();
        jdbc.update(sql, object);

        String sqlInt = "SELECT MAX(IDFILME) FROM Filmes";
        Map<String, Object> newInt = jdbc.queryForMap(sqlInt);
        int newID = Integer.parseInt(newInt.get("Max").toString());

        String sql2 = "INSERT INTO Diretor_filmes(IDDIRETOR, IDFILME)" + " VALUES(?,?)";
        Object[] object2 = new Object[2];
        object2[0] = filmes.getIDDIRETOR();
        object2[1] = newID;

        jdbc.update(sql2, object2);

    }

    public Map<String, Object> selectfilme(int IDFILME) {
        String sql = "SELECT F.*, D.DIRETOR AS DIRETOR, D.IDDIRETOR AS IDDIRETOR FROM Filmes F INNER JOIN Diretor_filmes DF ON(DF.IDFILME = F.IDFILME) INNER JOIN Diretor D ON(D.IDDIRETOR = DF.IDDIRETOR) WHERE F.IDFILME = ?";
        Object[] object = new Object[1];
        object[0] = IDFILME;
        return jdbc.queryForMap(sql, object);
    }

    public List<Map<String, Object>> getFilmes() {
        String sql = "SELECT F.*, D.DIRETOR AS DIRETOR FROM Filmes F INNER JOIN Diretor_filmes DF ON(DF.IDFILME = F.IDFILME) INNER JOIN Diretor D ON(D.IDDIRETOR = DF.IDDIRETOR)";
        List<Map<String, Object>> filmes = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return filmes;
    }

    public void deleteFilme(int IDFILME) {
        String sql = "DELETE FROM Diretor_filmes WHERE IDFILME = ?";
        Object[] obj = new Object[1];
        obj[0] = IDFILME;
        jdbc.update(sql, obj);

        String sql2 = "DELETE FROM Filmes WHERE IDFILME = ?";
        Object[] obj2 = new Object[1];
        obj2[0] = IDFILME;
        jdbc.update(sql2, obj2);
    }

    public void updateFilme(int IDFILME, FilmeDTO filme) {
        String sql = "UPDATE Diretor_filmes SET IDDIRETOR = ? WHERE IDFILME = ?";
        Object[] object = new Object[2];
        object[0] = filme.getIDDIRETOR();
        object[1] = IDFILME;

        jdbc.update(sql, object);

        String sql2 = "UPDATE Filmes SET TITULO = ?, BIRTHYEAR = ?, SINOPSE = ? WHERE IDFILME = ?";
        Object[] object2 = new Object[4];
        object2[0] = filme.getTITULO();
        object2[1] = filme.getBIRTHYEAR();
        object2[2] = filme.getSINOPSE();
        object2[3] = IDFILME;
        jdbc.update(sql2, object2);
    }
}
