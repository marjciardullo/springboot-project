package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiretorService {

    @Autowired
    DiretorDAO diretorDao;

    public void insert(Diretor diretor) {
        diretorDao.insert(diretor);
    }

    public List<Map<String, Object>> select() {
        return diretorDao.select();
    }
}
