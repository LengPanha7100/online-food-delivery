package com.example.demospring.onlinefooddelivery.model.dto.request;

import com.example.demospring.onlinefooddelivery.model.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemRequest {
    private String name;
    private Double price;
    private String description;
    private Long restaurantId;
    private Long categoryId;

    public MenuItem toEntity(Restaurant restaurant , Category category){
        return new MenuItem(null,this.name,this.price,this.description,restaurant,category,null,null);
    }

    public MenuItem toEntity(Restaurant restaurant , Category category , Long id){
        return new MenuItem(id,this.name,this.price,this.description,restaurant,category,null,null);
    }
}
