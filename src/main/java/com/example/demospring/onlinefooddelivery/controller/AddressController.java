package com.example.demospring.onlinefooddelivery.controller;

import com.example.demospring.onlinefooddelivery.model.Address;
import com.example.demospring.onlinefooddelivery.model.dto.request.AddressRequest;
import com.example.demospring.onlinefooddelivery.model.dto.response.APIResponse;
import com.example.demospring.onlinefooddelivery.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService ;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<Address>>> getAllAddress(){
        List<Address> addresses = addressService.getAllAddress();
        APIResponse<List<Address>> apiResponse = APIResponse.<List<Address>>builder()
                .message("Get all address successfully!")
                .status(HttpStatus.OK)
                .payload(addresses)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Address>> getAddressById(@PathVariable Long id){
        Address addresses = addressService.getAddressById(id);
        APIResponse<Address> apiResponse = APIResponse.<Address>builder()
                .message("Get address by id successfully!")
                .status(HttpStatus.OK)
                .payload(addresses)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Address>> createAddress(@RequestBody AddressRequest addressRequest){
        Address addresses = addressService.createAddress(addressRequest);
        APIResponse<Address> apiResponse = APIResponse.<Address>builder()
                .message("Created address successfully!")
                .status(HttpStatus.CREATED)
                .payload(addresses)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Address>> updateAddressById(@PathVariable Long id , @RequestBody AddressRequest addressRequest){
        Address addresses = addressService.updateAddressById(id,addressRequest);
        APIResponse<Address> apiResponse = APIResponse.<Address>builder()
                .message("Updated address by id successfully!")
                .status(HttpStatus.OK)
                .payload(addresses)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Address>> deleteAddressById(@PathVariable Long id ){
        addressService.deleteAddressById(id);
        APIResponse<Address> apiResponse = APIResponse.<Address>builder()
                .message("Deleted address by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
