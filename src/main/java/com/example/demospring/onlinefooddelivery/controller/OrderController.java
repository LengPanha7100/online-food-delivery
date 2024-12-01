package com.example.demospring.onlinefooddelivery.controller;

import com.example.demospring.onlinefooddelivery.model.Order;
import com.example.demospring.onlinefooddelivery.model.dto.enums.EStatus;
import com.example.demospring.onlinefooddelivery.model.dto.request.OrderRequest;
import com.example.demospring.onlinefooddelivery.model.dto.response.APIResponse;
import com.example.demospring.onlinefooddelivery.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<Order>>> getAllOrder(){
        List<Order> orders = orderService.getAllOrder();
        APIResponse<List<Order>> apiResponse = APIResponse.<List<Order>>builder()
                .message("Get all order successfully")
                .status(HttpStatus.OK)
                .payload(orders)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Order>> getOrderById(@PathVariable Long id){
        Order orders = orderService.getOrderById(id);
        APIResponse<Order> apiResponse = APIResponse.<Order>builder()
                .message("Get order by id successfully")
                .status(HttpStatus.OK)
                .payload(orders)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/status")
    public ResponseEntity<APIResponse<List<Order>>> getOrderByStatus(@RequestParam EStatus status){
        List<Order> orders = orderService.getOrderByStatus(status);
        APIResponse<List<Order>> apiResponse = APIResponse.<List<Order>>builder()
                .message("Get all order successfully")
                .status(HttpStatus.OK)
                .payload(orders)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Order>> createOrder(@RequestBody OrderRequest orderRequest , @RequestParam EStatus status){
        Order orders = orderService.createOrder(orderRequest , status);
        APIResponse<Order> apiResponse = APIResponse.<Order>builder()
                .message("Created order successfully")
                .status(HttpStatus.OK)
                .payload(orders)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Order>> updateOrderById(@PathVariable Long id , @RequestBody OrderRequest orderRequest ,  @RequestParam EStatus status){
        Order orders = orderService.updateOrderById(id ,orderRequest ,status);
        APIResponse<Order> apiResponse = APIResponse.<Order>builder()
                .message("Update order by id successfully")
                .status(HttpStatus.OK)
                .payload(orders)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Order>> deleteOrderById(@PathVariable Long id ){
        orderService.deleteOrderById(id);
        APIResponse<Order> apiResponse = APIResponse.<Order>builder()
                .message("Delete order by id successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
