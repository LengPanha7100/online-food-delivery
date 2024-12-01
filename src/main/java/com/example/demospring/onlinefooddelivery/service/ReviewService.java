package com.example.demospring.onlinefooddelivery.service;

import com.example.demospring.onlinefooddelivery.model.Review;
import com.example.demospring.onlinefooddelivery.model.dto.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview();

    Review getReviewById(Long id);

    Review createReview(ReviewRequest reviewRequest);

    Review updateReviewById(Long id, ReviewRequest reviewRequest);

    void deleteReviewById(Long id);
}
