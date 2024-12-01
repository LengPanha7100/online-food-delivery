package com.example.demospring.onlinefooddelivery.service.serviceImp;
import com.example.demospring.onlinefooddelivery.exception.NotFoundException;
import com.example.demospring.onlinefooddelivery.model.MenuItem;
import com.example.demospring.onlinefooddelivery.model.Restaurant;
import com.example.demospring.onlinefooddelivery.model.Review;
import com.example.demospring.onlinefooddelivery.model.dto.request.ReviewRequest;
import com.example.demospring.onlinefooddelivery.repository.ReviewRepository;
import com.example.demospring.onlinefooddelivery.service.MenuItemService;
import com.example.demospring.onlinefooddelivery.service.RestaurantService;
import com.example.demospring.onlinefooddelivery.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantService restaurantService;
    private final MenuItemService menuItemService;

    public ReviewServiceImp(ReviewRepository reviewRepository, RestaurantService restaurantService, MenuItemService menuItemService) {
        this.reviewRepository = reviewRepository;
        this.restaurantService = restaurantService;
        this.menuItemService = menuItemService;
    }

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Review by id "+id+" not found")
        );
    }

    @Override
    public Review createReview(ReviewRequest reviewRequest) {
        Restaurant restaurant = restaurantService.getRestaurantById(reviewRequest.getRestaurantId());
        MenuItem menuItem = menuItemService.getMenuItemById(reviewRequest.getMenuItemId());
        return reviewRepository.save(reviewRequest.toEntity(restaurant,menuItem));
    }

    @Override
    public Review updateReviewById(Long id, ReviewRequest reviewRequest) {
        getReviewById(id);
        Restaurant restaurant = restaurantService.getRestaurantById(reviewRequest.getRestaurantId());
        MenuItem menuItem = menuItemService.getMenuItemById(reviewRequest.getMenuItemId());
        return reviewRepository.save(reviewRequest.toEntity(restaurant,menuItem));
    }

    @Override
    public void deleteReviewById(Long id) {
        getReviewById(id);
        reviewRepository.deleteById(id);
    }
}
