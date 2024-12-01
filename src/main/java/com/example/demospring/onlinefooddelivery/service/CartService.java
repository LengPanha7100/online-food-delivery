package com.example.demospring.onlinefooddelivery.service;

import com.example.demospring.onlinefooddelivery.model.Cart;
import com.example.demospring.onlinefooddelivery.model.CartItem;
import com.example.demospring.onlinefooddelivery.model.dto.request.CartItemRequest;

import java.util.List;

public interface CartService {

    Cart getCartByCustomerId(Long id);

    CartItem createCartItem(CartItemRequest cartItemRequest , Long customerId);

    CartItem updateCartByCustomerId(Long customerId, CartItemRequest cartItemRequest);

    void deleteCartById(Long customerId , Long menuItemId);
}
