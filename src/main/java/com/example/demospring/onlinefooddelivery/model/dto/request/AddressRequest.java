package com.example.demospring.onlinefooddelivery.model.dto.request;

import com.example.demospring.onlinefooddelivery.model.Address;
import com.example.demospring.onlinefooddelivery.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private Long customerId;

    public Address toEntity(Customer customer){
        return new Address(null,this.street,this.city,this.state,this.postalCode, customer);
    }
    public Address toEntity(Customer customer , Long id){
        return new Address(id,this.street,this.city,this.state,this.postalCode, customer);
    }
}
