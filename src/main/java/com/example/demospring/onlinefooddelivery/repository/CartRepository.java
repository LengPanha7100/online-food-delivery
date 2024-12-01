package com.example.demospring.onlinefooddelivery.repository;

import com.example.demospring.onlinefooddelivery.model.Cart;
import com.example.demospring.onlinefooddelivery.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart , Long> {
    Cart findByCustomerId (Long customerId);

}
