package com.example.demospring.onlinefooddelivery.repository;

import com.example.demospring.onlinefooddelivery.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
