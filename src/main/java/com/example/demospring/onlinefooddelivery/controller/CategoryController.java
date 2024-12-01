package com.example.demospring.onlinefooddelivery.controller;

import com.example.demospring.onlinefooddelivery.model.Category;
import com.example.demospring.onlinefooddelivery.model.dto.request.CategoryRequest;
import com.example.demospring.onlinefooddelivery.model.dto.response.APIResponse;
import com.example.demospring.onlinefooddelivery.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Category>>> getAllCategory(){
        List<Category> categories = categoryService.getAllCategory();
        APIResponse<List<Category>> apiResponse = APIResponse.<List<Category>>builder()
                .message("Get all category successfully!")
                .status(HttpStatus.OK)
                .payload(categories)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Category>> getCategoryById(@PathVariable Long id ){
        Category categories = categoryService.getCategoryById(id);
        APIResponse<Category> apiResponse = APIResponse.<Category>builder()
                .message("Get category by id successfully!")
                .status(HttpStatus.OK)
                .payload(categories)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Category>> createCategory(@RequestBody CategoryRequest categoryRequest){
        Category categories = categoryService.createCategory(categoryRequest);
        APIResponse<Category> apiResponse = APIResponse.<Category>builder()
                .message("Created category successfully!")
                .status(HttpStatus.CREATED)
                .payload(categories)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Category>> updateCategoryById(@PathVariable Long id , @RequestBody CategoryRequest categoryRequest ){
        Category categories = categoryService.updateCategoryById(id,categoryRequest);
        APIResponse<Category> apiResponse = APIResponse.<Category>builder()
                .message("Updated category by id successfully!")
                .status(HttpStatus.OK)
                .payload(categories)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Category>> deleteCategoryById(@PathVariable Long id  ){
       categoryService.deleteCategoryById(id);
        APIResponse<Category> apiResponse = APIResponse.<Category>builder()
                .message("Deleted category by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
