package com.example.demospring.onlinefooddelivery.service.serviceImp;

import com.example.demospring.onlinefooddelivery.exception.NotFoundException;
import com.example.demospring.onlinefooddelivery.model.Restaurant;
import com.example.demospring.onlinefooddelivery.model.dto.request.RestaurantRequest;
import com.example.demospring.onlinefooddelivery.repository.RestaurantRepository;
import com.example.demospring.onlinefooddelivery.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImp implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImp(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Restaurant by id "+id+" not found")
        );
    }

    @Override
    public Restaurant createRestaurant(RestaurantRequest restaurantRequest) {
        return restaurantRepository.save(restaurantRequest.toEntity());
    }

    @Override
    public Restaurant updateRestaurantById(Long id, RestaurantRequest restaurantRequest) {
        getRestaurantById(id);
        return restaurantRepository.save(restaurantRequest.toEntity(id));
    }

    @Override
    public void deleteRestaurantById(Long id) {
        getRestaurantById(id);
        restaurantRepository.deleteById(id);
    }
}
