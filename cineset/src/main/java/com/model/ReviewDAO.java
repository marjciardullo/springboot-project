package com.model;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO {

    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void insertReview(Review review) {
        String sql = "INSERT INTO Reviews(REVIEW)" + "VALUES(?)";

        Object[] object = new Object[1];
        object[0] = review.getREVIEW();

        jdbc.update(sql, object);
    }

    public Map<String, Object> selecReview(int IDREVIEW) {
        String sql = "SELECT * FROM Reviews WHERE Reviews.IDREVIEW = ?";
        Object[] object = new Object[1];
        object[0] = IDREVIEW;
        return jdbc.queryForMap(sql, object);
    }

}
