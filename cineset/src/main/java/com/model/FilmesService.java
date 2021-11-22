package com.model;

//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmesService {
    @Autowired
    FilmesDAO filmeDao;

    public void insertFilme(Filmes film) {
        filmeDao.insertfilme(film);
    }

    // public Map<String, Object> selectfilme(int ID) {
    // return filmeDao.selectfilme(ID);
    // }
}
