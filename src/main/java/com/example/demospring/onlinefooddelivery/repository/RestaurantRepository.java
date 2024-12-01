package com.example.demospring.onlinefooddelivery.repository;

import com.example.demospring.onlinefooddelivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant , Long> {
}
