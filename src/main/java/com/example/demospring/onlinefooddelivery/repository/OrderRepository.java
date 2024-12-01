package com.example.demospring.onlinefooddelivery.repository;

import com.example.demospring.onlinefooddelivery.model.Order;
import com.example.demospring.onlinefooddelivery.model.dto.enums.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long> {
    List<Order> findAllByStatus (EStatus status);
}
