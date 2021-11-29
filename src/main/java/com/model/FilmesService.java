package com.model;

import java.util.List;
import java.util.Map;

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

    public Map<String, Object> selectfilme(int IDFILME) {
        return filmeDao.selectfilme(IDFILME);
    }

    public List<Map<String, Object>> getFilmes() {
        return filmeDao.getFilmes();
    }

    public void deleteFilme(int IDFILME) {
        filmeDao.deleteFilme(IDFILME);
    }

    public void updateFilme(int IDFILME, Filmes filme) {
        filmeDao.updateFilme(IDFILME, filme);
    }
}
