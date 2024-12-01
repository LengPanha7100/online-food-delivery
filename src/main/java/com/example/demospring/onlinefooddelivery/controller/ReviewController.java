package com.example.demospring.onlinefooddelivery.controller;

import com.example.demospring.onlinefooddelivery.model.Review;
import com.example.demospring.onlinefooddelivery.model.dto.request.ReviewRequest;
import com.example.demospring.onlinefooddelivery.model.dto.response.APIResponse;
import com.example.demospring.onlinefooddelivery.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Review>>> getAllReview(){
        List<Review> reviews = reviewService.getAllReview();
        APIResponse<List<Review>> apiResponse = APIResponse.<List<Review>>builder()
                .message("Get all review successfully")
                .status(HttpStatus.OK)
                .payload(reviews)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Review>> getReviewById(@PathVariable Long id){
        Review reviews = reviewService.getReviewById(id);
        APIResponse<Review> apiResponse = APIResponse.<Review>builder()
                .message("Get review by id successfully")
                .status(HttpStatus.OK)
                .payload(reviews)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Review>> createReview(@RequestBody ReviewRequest reviewRequest){
        Review reviews = reviewService.createReview(reviewRequest);
        APIResponse<Review> apiResponse = APIResponse.<Review>builder()
                .message("Create review successfully")
                .status(HttpStatus.OK)
                .payload(reviews)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Review>> updateReviewById(@PathVariable Long id , @RequestBody ReviewRequest reviewRequest){
        Review reviews = reviewService.updateReviewById(id , reviewRequest);
        APIResponse<Review> apiResponse = APIResponse.<Review>builder()
                .message("Updated review by id successfully")
                .status(HttpStatus.OK)
                .payload(reviews)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Review>> deleteReviewById(@PathVariable Long id){
        reviewService.deleteReviewById(id);
        APIResponse<Review> apiResponse = APIResponse.<Review>builder()
                .message("Delete review by id successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
