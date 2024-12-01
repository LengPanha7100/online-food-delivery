package com.example.demospring.onlinefooddelivery.repository;

import com.example.demospring.onlinefooddelivery.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem , Long> {
    List<MenuItem> findAllByNameContainingIgnoreCaseOrCategory_NameContainingIgnoreCase (String name , String categoryName);
}
