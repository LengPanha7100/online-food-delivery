package com.example.demospring.onlinefooddelivery.controller;

import com.example.demospring.onlinefooddelivery.model.Restaurant;
import com.example.demospring.onlinefooddelivery.model.dto.request.RestaurantRequest;
import com.example.demospring.onlinefooddelivery.model.dto.response.APIResponse;
import com.example.demospring.onlinefooddelivery.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Restaurant>>> getAllRestaurant(){
        List<Restaurant> restaurants = restaurantService.getAllRestaurant();
        APIResponse<List<Restaurant>> apiResponse = APIResponse.<List<Restaurant>>builder()
                .message("Successfully!")
                .status(HttpStatus.OK)
                .payload(restaurants)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Restaurant>> getRestaurantById(@PathVariable Long id){
        Restaurant restaurants = restaurantService.getRestaurantById(id);
        APIResponse<Restaurant> apiResponse = APIResponse.<Restaurant>builder()
                .message("Successfully!")
                .status(HttpStatus.OK)
                .payload(restaurants)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Restaurant>> createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        Restaurant restaurants = restaurantService.createRestaurant(restaurantRequest);
        APIResponse<Restaurant> apiResponse = APIResponse.<Restaurant>builder()
                .message("Successfully!")
                .status(HttpStatus.OK)
                .payload(restaurants)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Restaurant>> updateRestaurantById(@PathVariable Long id , @RequestBody RestaurantRequest restaurantRequest){
        Restaurant restaurants = restaurantService.updateRestaurantById(id,restaurantRequest);
        APIResponse<Restaurant> apiResponse = APIResponse.<Restaurant>builder()
                .message("Successfully!")
                .status(HttpStatus.OK)
                .payload(restaurants)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Restaurant>> deleteRestaurantById(@PathVariable Long id){
        restaurantService.deleteRestaurantById(id);
        APIResponse<Restaurant> apiResponse = APIResponse.<Restaurant>builder()
                .message("Successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
