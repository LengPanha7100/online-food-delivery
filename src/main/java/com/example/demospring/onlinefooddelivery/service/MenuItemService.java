package com.example.demospring.onlinefooddelivery.service;

import com.example.demospring.onlinefooddelivery.model.MenuItem;
import com.example.demospring.onlinefooddelivery.model.dto.request.MenuItemRequest;

import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAllMenuItem();

    MenuItem getMenuItemById(Long id);

    MenuItem createMenuItem(MenuItemRequest menuItemRequest);

    MenuItem updateMenuItemById(Long id, MenuItemRequest menuItemRequest);

    void deleteMenuItemById(Long id);

    List<MenuItem> getMenuItemNameAndCategoryName(String name, String categoryName);
}
