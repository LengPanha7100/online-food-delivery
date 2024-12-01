package com.example.demospring.onlinefooddelivery.controller;

import com.example.demospring.onlinefooddelivery.model.Cart;
import com.example.demospring.onlinefooddelivery.model.CartItem;
import com.example.demospring.onlinefooddelivery.model.dto.request.CartItemRequest;
import com.example.demospring.onlinefooddelivery.model.dto.response.APIResponse;
import com.example.demospring.onlinefooddelivery.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("customer/{customerId}")
    public ResponseEntity<APIResponse<Cart>> getCartByCustomerId(@PathVariable Long customerId){
        Cart carts = cartService.getCartByCustomerId(customerId);
        APIResponse<Cart> apiResponse = APIResponse.<Cart>builder()
                .message("Get cart by customer id successfully")
                .status(HttpStatus.OK)
                .payload(carts)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping("customer/{customerId}/addCartItem")
    public ResponseEntity<APIResponse<CartItem>> createCartItem(@RequestBody CartItemRequest cartItemRequest , @PathVariable Long customerId){
        CartItem cartItem = cartService.createCartItem(cartItemRequest , customerId);
        APIResponse<CartItem> apiResponse = APIResponse.<CartItem>builder()
                .message("Create cart successfully")
                .status(HttpStatus.OK)
                .payload(cartItem)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("customer/{customerId}/updateCartItem")
    public ResponseEntity<APIResponse<CartItem>> updateCartByCustomerId(@PathVariable Long customerId , @RequestBody CartItemRequest cartItemRequest){
        CartItem carts = cartService.updateCartByCustomerId(customerId,cartItemRequest);
        APIResponse<CartItem> apiResponse = APIResponse.<CartItem>builder()
                .message("Update cart by customer id  successfully")
                .status(HttpStatus.OK)
                .payload(carts)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{customerId}/menuItem/{menuItemId}/removeItem")
    public ResponseEntity<APIResponse<CartItem>> deleteCartById(@PathVariable Long customerId , @PathVariable Long menuItemId){
        cartService.deleteCartById(customerId,menuItemId);
        APIResponse<CartItem> apiResponse = APIResponse.<CartItem>builder()
                .message("Deleted cart by customer id successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
