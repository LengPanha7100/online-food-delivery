package com.example.demospring.onlinefooddelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String quantity;
    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;
    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Address> addresses;
    @OneToOne(mappedBy = "customer" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Cart cart;

}
