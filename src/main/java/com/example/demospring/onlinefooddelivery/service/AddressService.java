package com.example.demospring.onlinefooddelivery.service;

import com.example.demospring.onlinefooddelivery.model.Address;
import com.example.demospring.onlinefooddelivery.model.dto.request.AddressRequest;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddress();

    Address getAddressById(Long id);

    Address createAddress(AddressRequest addressRequest);

    Address updateAddressById(Long id, AddressRequest addressRequest);

    void deleteAddressById(Long id);
}
