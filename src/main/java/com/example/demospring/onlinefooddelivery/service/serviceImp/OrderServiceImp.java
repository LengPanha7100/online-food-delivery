package com.example.demospring.onlinefooddelivery.service.serviceImp;

import com.example.demospring.onlinefooddelivery.exception.NotFoundException;
import com.example.demospring.onlinefooddelivery.model.*;
import com.example.demospring.onlinefooddelivery.model.dto.enums.EStatus;
import com.example.demospring.onlinefooddelivery.model.dto.request.OrderItemRequest;
import com.example.demospring.onlinefooddelivery.model.dto.request.OrderRequest;
import com.example.demospring.onlinefooddelivery.repository.OrderItemRepository;
import com.example.demospring.onlinefooddelivery.repository.OrderRepository;
import com.example.demospring.onlinefooddelivery.service.CustomerService;
import com.example.demospring.onlinefooddelivery.service.DeliveryPersonService;
import com.example.demospring.onlinefooddelivery.service.MenuItemService;
import com.example.demospring.onlinefooddelivery.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final DeliveryPersonService deliveryPersonService;
    private final OrderItemRepository orderItemRepository;
    private final MenuItemService menuItemService;
    public OrderServiceImp(OrderRepository orderRepository, CustomerService customerService, DeliveryPersonService deliveryPersonService, OrderItemRepository orderItemRepository, MenuItemService menuItemService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.deliveryPersonService = deliveryPersonService;
        this.orderItemRepository = orderItemRepository;
        this.menuItemService = menuItemService;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Order by id "+id+" not found")
        );
    }

    @Override
    public Order createOrder(OrderRequest orderRequest , EStatus status) {
        Customer customer = customerService.getCustomerById(orderRequest.getCustomerId());
        DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPersonById(orderRequest.getDeliveryPersonId());
        Order order = orderRepository.save(orderRequest.toEntity(status,customer,deliveryPerson));
        for(OrderItemRequest orderItemRequest : orderRequest.getOrderItemRequest()){
            MenuItem menuItem = menuItemService.getMenuItemById(orderItemRequest.getMenuItemId());
            OrderItem orderItem1 = orderItemRepository.save(orderItemRequest.toEntity(menuItem , order));
            order.getOrderItems().add(orderItem1);
        }
        return order;
    }

    @Override
    public Order updateOrderById(Long id, OrderRequest orderRequest , EStatus status) {
        getOrderById(id);
        Customer customer = customerService.getCustomerById(orderRequest.getCustomerId());
        DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPersonById(orderRequest.getDeliveryPersonId());
        Order order = orderRepository.save(orderRequest.toEntity(id,status,customer,deliveryPerson));
        for(OrderItemRequest orderItemRequest : orderRequest.getOrderItemRequest()){
            MenuItem menuItem = menuItemService.getMenuItemById(orderItemRequest.getMenuItemId());
            OrderItem orderItem1 = orderItemRepository.save(orderItemRequest.toEntity(menuItem , order));
            order.getOrderItems().add(orderItem1);
        }
        return order;
    }

    @Override
    public void deleteOrderById(Long id) {
        getOrderById(id);
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrderByStatus(EStatus status) {
        return orderRepository.findAllByStatus(status);
    }
}
