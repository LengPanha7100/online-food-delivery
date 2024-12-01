package com.example.demospring.onlinefooddelivery.service;

import com.example.demospring.onlinefooddelivery.model.DeliveryPerson;
import com.example.demospring.onlinefooddelivery.model.dto.request.DeliveryPersonRequest;

import java.util.List;

public interface DeliveryPersonService {
    List<DeliveryPerson> getAllDeliveryPerson();

    DeliveryPerson getDeliveryPersonById(Long id);

    DeliveryPerson createDeliveryPerson(DeliveryPersonRequest deliveryPersonRequest);

    DeliveryPerson updateDeliveryPersonById(Long id, DeliveryPersonRequest deliveryPersonRequest);

    void deleteDeliveryPersonById(Long id);
}
