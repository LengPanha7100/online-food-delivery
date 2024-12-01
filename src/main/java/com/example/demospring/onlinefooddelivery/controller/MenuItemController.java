package com.example.demospring.onlinefooddelivery.controller;

import com.example.demospring.onlinefooddelivery.model.MenuItem;
import com.example.demospring.onlinefooddelivery.model.dto.request.MenuItemRequest;
import com.example.demospring.onlinefooddelivery.model.dto.response.APIResponse;
import com.example.demospring.onlinefooddelivery.service.MenuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/menuItems")
public class MenuItemController {
    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<MenuItem>>> getAllMenuItem(){
        List<MenuItem> menuItems = menuItemService.getAllMenuItem();
        APIResponse<List<MenuItem>> apiResponse = APIResponse.<List<MenuItem>>builder()
                .message("Get all menu item successfully!")
                .status(HttpStatus.OK)
                .payload(menuItems)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<MenuItem>> getMenuItemById(@PathVariable Long id){
        MenuItem menuItems = menuItemService.getMenuItemById(id);
        APIResponse<MenuItem> apiResponse = APIResponse.<MenuItem>builder()
                .message("Get menu item by id successfully!")
                .status(HttpStatus.OK)
                .payload(menuItems)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/search")
    public ResponseEntity<APIResponse<List<MenuItem>>> getMenuItemNameAndCategoryName(@RequestParam String name , @RequestParam String categoryName){
        List<MenuItem> menuItems = menuItemService.getMenuItemNameAndCategoryName(name,categoryName);
        APIResponse<List<MenuItem>> apiResponse = APIResponse.<List<MenuItem>>builder()
                .message("Get menu item by name and category successfully!")
                .status(HttpStatus.OK)
                .payload(menuItems)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<MenuItem>> createMenuItem(@RequestBody MenuItemRequest menuItemRequest){
        MenuItem menuItems = menuItemService.createMenuItem(menuItemRequest);
        APIResponse<MenuItem> apiResponse = APIResponse.<MenuItem>builder()
                .message("Created menu item successfully!")
                .status(HttpStatus.OK)
                .payload(menuItems)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<MenuItem>> updateMenuItemById(@PathVariable Long id,@RequestBody MenuItemRequest menuItemRequest){
        MenuItem menuItems = menuItemService.updateMenuItemById(id , menuItemRequest);
        APIResponse<MenuItem> apiResponse = APIResponse.<MenuItem>builder()
                .message("Updated menu item by id successfully!")
                .status(HttpStatus.OK)
                .payload(menuItems)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<MenuItem>> deleteMenuItemById(@PathVariable Long id){
        menuItemService.deleteMenuItemById(id);
        APIResponse<MenuItem> apiResponse = APIResponse.<MenuItem>builder()
                .message("Deleted menu item by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
