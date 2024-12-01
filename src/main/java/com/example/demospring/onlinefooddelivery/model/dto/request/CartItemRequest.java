package com.example.demospring.onlinefooddelivery.model.dto.request;

import com.example.demospring.onlinefooddelivery.model.Cart;
import com.example.demospring.onlinefooddelivery.model.CartItem;
import com.example.demospring.onlinefooddelivery.model.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemRequest {
    private Integer quantity;
    private Long menuItemId;

    public CartItem toEntity(MenuItem menuItem , Cart cart){
        return new CartItem(null,this.quantity,cart,menuItem);
    }
    public CartItem toEntity( Long id ,MenuItem menuItem,Cart cart){
        return new CartItem(id,this.quantity,cart,menuItem);
    }
}
