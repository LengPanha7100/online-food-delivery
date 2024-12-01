package com.example.demospring.onlinefooddelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "menuItem" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CartItem> cartItem;
    @OneToMany(mappedBy = "menuItem" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;
}
