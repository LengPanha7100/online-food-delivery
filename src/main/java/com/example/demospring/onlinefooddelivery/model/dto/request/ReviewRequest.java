package com.example.demospring.onlinefooddelivery.model.dto.request;

import com.example.demospring.onlinefooddelivery.model.MenuItem;
import com.example.demospring.onlinefooddelivery.model.Restaurant;
import com.example.demospring.onlinefooddelivery.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private Double rating;
    private String comment;
    private String contact;
    private Long restaurantId;
    private Long menuItemId;

    public Review toEntity(Restaurant restaurant , MenuItem menuItem){
        return new Review(null,this.rating,this.comment,this.contact,restaurant,menuItem);
    }
    public Review toEntity(Restaurant restaurant , MenuItem menuItem , Long id){
        return new Review(id,this.rating,this.comment,this.contact,restaurant,menuItem);
    }
}
