package com.abhiruchi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiruchi.model.Review;
import com.abhiruchi.repositories.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveOrUpdateABook(Review review) {
        return reviewRepository.save(review);
    }

    public Review findReviewById(Long bookId) {
        return reviewRepository.getByReviewId(bookId);
    }

    public Iterable<Review> findAll() {
        return reviewRepository.findAll();
    }
}
