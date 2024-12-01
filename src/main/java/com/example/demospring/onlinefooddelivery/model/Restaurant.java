package com.example.demospring.onlinefooddelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String contact;
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MenuItem> menuItems;
    @OneToMany(mappedBy = "restaurant" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;
}
