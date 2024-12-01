package com.example.demospring.onlinefooddelivery.model.dto.request;

import com.example.demospring.onlinefooddelivery.model.Customer;
import com.example.demospring.onlinefooddelivery.model.DeliveryPerson;
import com.example.demospring.onlinefooddelivery.model.Order;
import com.example.demospring.onlinefooddelivery.model.OrderItem;
import com.example.demospring.onlinefooddelivery.model.dto.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private LocalDate orderDate;
    private Long customerId;
    private List<OrderItemRequest> orderItemRequest;
    private Long deliveryPersonId;

    public Order toEntity(EStatus status , Customer customer , DeliveryPerson deliveryPerson) {
        return new Order(null,this.orderDate,status,customer,deliveryPerson,new ArrayList<>());
    }
    public Order toEntity(Long id,EStatus status , Customer customer , DeliveryPerson deliveryPerson) {
        return new Order(id,this.orderDate,status,customer,deliveryPerson,new ArrayList<>());
    }

}
