package com.example.demospring.onlinefooddelivery.service;

import com.example.demospring.onlinefooddelivery.model.Order;
import com.example.demospring.onlinefooddelivery.model.dto.enums.EStatus;
import com.example.demospring.onlinefooddelivery.model.dto.request.OrderRequest;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();

    Order getOrderById(Long id);

    Order createOrder(OrderRequest orderRequest , EStatus status);

    Order updateOrderById(Long id, OrderRequest orderRequest ,EStatus status );

    void deleteOrderById(Long id);

    List<Order> getOrderByStatus(EStatus status);
}
