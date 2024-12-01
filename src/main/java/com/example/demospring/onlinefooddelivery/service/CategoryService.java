package com.example.demospring.onlinefooddelivery.service;

import com.example.demospring.onlinefooddelivery.model.Category;
import com.example.demospring.onlinefooddelivery.model.dto.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Category getCategoryById(Long id);

    Category createCategory(CategoryRequest categoryRequest);

    Category updateCategoryById(Long id, CategoryRequest categoryRequest);

    void deleteCategoryById(Long id);
}
