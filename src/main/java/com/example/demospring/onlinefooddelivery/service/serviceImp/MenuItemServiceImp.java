package com.example.demospring.onlinefooddelivery.service.serviceImp;

import com.example.demospring.onlinefooddelivery.exception.NotFoundException;
import com.example.demospring.onlinefooddelivery.model.Category;
import com.example.demospring.onlinefooddelivery.model.MenuItem;
import com.example.demospring.onlinefooddelivery.model.Restaurant;
import com.example.demospring.onlinefooddelivery.model.dto.request.MenuItemRequest;
import com.example.demospring.onlinefooddelivery.repository.MenuItemRepository;
import com.example.demospring.onlinefooddelivery.service.CategoryService;
import com.example.demospring.onlinefooddelivery.service.MenuItemService;
import com.example.demospring.onlinefooddelivery.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImp implements MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final CategoryService categoryService;
    private final RestaurantService restaurantService;

    public MenuItemServiceImp(MenuItemRepository menuItemRepository, CategoryService categoryService, RestaurantService restaurantService) {
        this.menuItemRepository = menuItemRepository;
        this.categoryService = categoryService;
        this.restaurantService = restaurantService;
    }

    @Override
    public List<MenuItem> getAllMenuItem() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Menu item by id "+ id + " not found")
        );
    }

    @Override
    public MenuItem createMenuItem(MenuItemRequest menuItemRequest) {
        Category category = categoryService.getCategoryById(menuItemRequest.getCategoryId());
        Restaurant restaurant = restaurantService.getRestaurantById(menuItemRequest.getRestaurantId());
        return menuItemRepository.save(menuItemRequest.toEntity(restaurant , category));
    }

    @Override
    public MenuItem updateMenuItemById(Long id, MenuItemRequest menuItemRequest) {
        getMenuItemById(id);
        Category category = categoryService.getCategoryById(menuItemRequest.getCategoryId());
        Restaurant restaurant = restaurantService.getRestaurantById(menuItemRequest.getRestaurantId());
        return menuItemRepository.save(menuItemRequest.toEntity(restaurant , category));
    }

    @Override
    public void deleteMenuItemById(Long id) {
        getMenuItemById(id);
        menuItemRepository.deleteById(id);
    }

    @Override
    public List<MenuItem> getMenuItemNameAndCategoryName(String name, String categoryName) {
        return menuItemRepository.findAllByNameContainingIgnoreCaseOrCategory_NameContainingIgnoreCase(name,categoryName);
    }
}
