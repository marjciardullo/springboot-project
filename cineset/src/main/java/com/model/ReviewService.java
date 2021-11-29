package com.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewDAO reviewDao;

    public void insertReview(Review review) {
        reviewDao.insertReview(review);
    }

    public Map<String, Object> selectReview(int IDREVIEW) {
        return reviewDao.selecReview(IDREVIEW);
    }
}
