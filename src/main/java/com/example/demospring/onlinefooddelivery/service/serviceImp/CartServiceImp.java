package com.example.demospring.onlinefooddelivery.service.serviceImp;

import com.example.demospring.onlinefooddelivery.model.Cart;
import com.example.demospring.onlinefooddelivery.model.CartItem;
import com.example.demospring.onlinefooddelivery.model.Customer;
import com.example.demospring.onlinefooddelivery.model.MenuItem;
import com.example.demospring.onlinefooddelivery.model.dto.request.CartItemRequest;
import com.example.demospring.onlinefooddelivery.repository.CartItemRepository;
import com.example.demospring.onlinefooddelivery.repository.CartRepository;
import com.example.demospring.onlinefooddelivery.service.CartService;
import com.example.demospring.onlinefooddelivery.service.CustomerService;
import com.example.demospring.onlinefooddelivery.service.MenuItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final MenuItemService  menuItemService;
    private final CustomerService customerService;
    public CartServiceImp(CartRepository cartRepository, CartItemRepository cartItemRepository, MenuItemService menuItemService, CustomerService customerService) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.menuItemService = menuItemService;
        this.customerService = customerService;
    }

    @Override
    public Cart getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    @Override
    public CartItem createCartItem(CartItemRequest cartItemRequest , Long customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if(cart == null){
            Customer customer = customerService.getCustomerById(customerId);
            Cart newCart = new Cart(null,customer,List.of());
            Cart cart1 = cartRepository.save(newCart);
            MenuItem menuItem = menuItemService.getMenuItemById(cartItemRequest.getMenuItemId());
            CartItem cartItem = cartItemRepository.save(cartItemRequest.toEntity(menuItem,cart1));
            return cartItem;
        }
        MenuItem menuItem = menuItemService.getMenuItemById(cartItemRequest.getMenuItemId());
        CartItem cartItem = cartItemRepository.save(cartItemRequest.toEntity(menuItem,cart));
        return cartItem;
    }

    @Override
    public CartItem updateCartByCustomerId(Long customerId, CartItemRequest cartItemRequest) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if(cart == null){
            Customer customer = customerService.getCustomerById(customerId);
            Cart newCart = new Cart(null,customer,List.of());  // create object cart
            Cart cart1 = cartRepository.save(newCart); //after create object next to create cart1
            MenuItem menuItem = menuItemService.getMenuItemById(cartItemRequest.getMenuItemId());
            CartItem cartItem = cartItemRepository.findByCartAndMenuItem(cart1,menuItem);
            cartItem.setQuantity(cartItemRequest.getQuantity());// update only quantity need to set quantity from cart item
            return cartItemRepository.save(cartItem);
        }
        return null;
    }

    @Override
    public void deleteCartById(Long customerId , Long menuItemId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);
        CartItem cartItem = cartItemRepository.findByCartAndMenuItem(cart,menuItem);
        cartItemRepository.delete(cartItem);
    }
}
