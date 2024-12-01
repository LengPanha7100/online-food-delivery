package com.example.demospring.onlinefooddelivery.model.dto.request;

import com.example.demospring.onlinefooddelivery.model.MenuItem;
import com.example.demospring.onlinefooddelivery.model.Order;
import com.example.demospring.onlinefooddelivery.model.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
    private Long price;
    private Long quantity;
    private Long menuItemId;

    public OrderItem toEntity(MenuItem menuItem , Order order){
        return new OrderItem(null,this.price,this.quantity,order,menuItem);
    }
    public OrderItem toEntity(Long id,MenuItem menuItem , Order order){
        return new OrderItem(id,this.price,this.quantity,order,menuItem);
    }
}
