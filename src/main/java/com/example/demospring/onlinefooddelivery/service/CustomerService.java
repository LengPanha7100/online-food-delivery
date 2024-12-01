package com.example.demospring.onlinefooddelivery.service;

import com.example.demospring.onlinefooddelivery.model.Customer;
import com.example.demospring.onlinefooddelivery.model.dto.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();

    Customer getCustomerById(Long id);

    Customer createCustomer(CustomerRequest customerRequest);

    Customer updateCustomerById(Long id, CustomerRequest customerRequest);

    void deletedCustomerById(Long id);
}
