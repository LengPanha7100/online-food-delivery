package com.example.demospring.onlinefooddelivery.service;

import com.example.demospring.onlinefooddelivery.model.Restaurant;
import com.example.demospring.onlinefooddelivery.model.dto.request.RestaurantRequest;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurant();

    Restaurant getRestaurantById(Long id);

    Restaurant createRestaurant(RestaurantRequest restaurantRequest);

    Restaurant updateRestaurantById(Long id, RestaurantRequest restaurantRequest);

    void deleteRestaurantById(Long id);
}
