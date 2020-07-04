package com.abhiruchi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abhiruchi.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    Review getByReviewId(Long id);
}
