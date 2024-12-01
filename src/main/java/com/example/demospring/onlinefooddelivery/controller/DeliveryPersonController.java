package com.example.demospring.onlinefooddelivery.controller;

import com.example.demospring.onlinefooddelivery.model.DeliveryPerson;
import com.example.demospring.onlinefooddelivery.model.dto.request.DeliveryPersonRequest;
import com.example.demospring.onlinefooddelivery.model.dto.response.APIResponse;
import com.example.demospring.onlinefooddelivery.service.DeliveryPersonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveryPerson")
public class DeliveryPersonController {
    private final DeliveryPersonService deliveryPersonService;

    public DeliveryPersonController(DeliveryPersonService deliveryPersonService) {
        this.deliveryPersonService = deliveryPersonService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<DeliveryPerson>>> getAllDeliveryPerson(){
        List<DeliveryPerson> deliveryPerson = deliveryPersonService.getAllDeliveryPerson();
        APIResponse<List<DeliveryPerson>> apiResponse = APIResponse.<List<DeliveryPerson>>builder()
                .message("Get all delivery person successfully!")
                .status(HttpStatus.OK)
                .payload(deliveryPerson)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<DeliveryPerson>> getDeliveryPersonById(@PathVariable Long id){
        DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPersonById(id);
        APIResponse<DeliveryPerson> apiResponse = APIResponse.<DeliveryPerson>builder()
                .message("Get delivery person by id successfully!")
                .status(HttpStatus.OK)
                .payload(deliveryPerson)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping
    public ResponseEntity<APIResponse<DeliveryPerson>> createDeliveryPerson(@RequestBody DeliveryPersonRequest deliveryPersonRequest){
        DeliveryPerson deliveryPerson = deliveryPersonService.createDeliveryPerson(deliveryPersonRequest);
        APIResponse<DeliveryPerson> apiResponse = APIResponse.<DeliveryPerson>builder()
                .message("Created delivery person successfully!")
                .status(HttpStatus.CREATED)
                .payload(deliveryPerson)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<DeliveryPerson>> updateDeliveryPersonById(@PathVariable Long id , @RequestBody DeliveryPersonRequest deliveryPersonRequest){
        DeliveryPerson deliveryPerson = deliveryPersonService.updateDeliveryPersonById(id , deliveryPersonRequest);
        APIResponse<DeliveryPerson> apiResponse = APIResponse.<DeliveryPerson>builder()
                .message("Updated delivery person by id successfully!")
                .status(HttpStatus.OK)
                .payload(deliveryPerson)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<DeliveryPerson>> deleteDeliveryPersonById(@PathVariable Long id){
        deliveryPersonService.deleteDeliveryPersonById(id);
        APIResponse<DeliveryPerson> apiResponse = APIResponse.<DeliveryPerson>builder()
                .message("Deleted delivery person by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
