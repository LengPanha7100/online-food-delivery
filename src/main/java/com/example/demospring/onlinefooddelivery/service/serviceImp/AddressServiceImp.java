package com.example.demospring.onlinefooddelivery.service.serviceImp;

import com.example.demospring.onlinefooddelivery.exception.NotFoundException;
import com.example.demospring.onlinefooddelivery.model.Address;
import com.example.demospring.onlinefooddelivery.model.Customer;
import com.example.demospring.onlinefooddelivery.model.dto.request.AddressRequest;
import com.example.demospring.onlinefooddelivery.repository.AddressRepository;
import com.example.demospring.onlinefooddelivery.service.AddressService;
import com.example.demospring.onlinefooddelivery.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {
    private final AddressRepository addressRepository;
    private final CustomerService customerService;


    public AddressServiceImp(AddressRepository addressRepository, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.customerService = customerService;
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Address by id "+ id+ " not found")
        );
    }

    @Override
    public Address createAddress(AddressRequest addressRequest) {
        Customer customer = customerService.getCustomerById(addressRequest.getCustomerId());
        return addressRepository.save(addressRequest.toEntity(customer));
    }

    @Override
    public Address updateAddressById(Long id, AddressRequest addressRequest) {
        getAddressById(id);
        Customer customer = customerService.getCustomerById(addressRequest.getCustomerId());
        return addressRepository.save(addressRequest.toEntity(customer,id));
    }

    @Override
    public void deleteAddressById(Long id) {
        getAddressById(id);
        addressRepository.deleteById(id);
    }
}
