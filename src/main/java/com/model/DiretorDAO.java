package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DiretorDAO {

    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void insert(Diretor diretor) {
        String sql = "INSERT INTO Diretor(DIRETOR) VALUES(?)";

        Object[] object = new Object[1];
        object[0] = diretor.getDIRETOR();

        jdbc.update(sql, object);
    }

    public List<Map<String, Object>> select() {
        String sql = "SELECT * FROM Diretor";
        List<Map<String, Object>> diretores = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return diretores;
    }

}
