package com.example.demospring.onlinefooddelivery.service.serviceImp;

import com.example.demospring.onlinefooddelivery.exception.NotFoundException;
import com.example.demospring.onlinefooddelivery.model.Customer;
import com.example.demospring.onlinefooddelivery.model.dto.request.CustomerRequest;
import com.example.demospring.onlinefooddelivery.repository.CustomerRepository;
import com.example.demospring.onlinefooddelivery.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Customer by id "+id+" not found")
        );
    }

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        return customerRepository.save(customerRequest.toEntity());
    }

    @Override
    public Customer updateCustomerById(Long id, CustomerRequest customerRequest) {
        getCustomerById(id);
        return customerRepository.save(customerRequest.toEntity(id));
    }

    @Override
    public void deletedCustomerById(Long id) {
        getCustomerById(id);
        customerRepository.deleteById(id);
    }
}
