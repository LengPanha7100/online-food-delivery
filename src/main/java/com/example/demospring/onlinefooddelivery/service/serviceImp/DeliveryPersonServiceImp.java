package com.example.demospring.onlinefooddelivery.service.serviceImp;

import com.example.demospring.onlinefooddelivery.exception.NotFoundException;
import com.example.demospring.onlinefooddelivery.model.DeliveryPerson;
import com.example.demospring.onlinefooddelivery.model.dto.request.DeliveryPersonRequest;
import com.example.demospring.onlinefooddelivery.repository.DeliveryPersonRepository;
import com.example.demospring.onlinefooddelivery.service.DeliveryPersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPersonServiceImp implements DeliveryPersonService {
    private final DeliveryPersonRepository deliveryPersonRepository;

    public DeliveryPersonServiceImp(DeliveryPersonRepository deliveryPersonRepository) {
        this.deliveryPersonRepository = deliveryPersonRepository;
    }

    @Override
    public List<DeliveryPerson> getAllDeliveryPerson() {
        return deliveryPersonRepository.findAll();
    }

    @Override
    public DeliveryPerson getDeliveryPersonById(Long id) {
        DeliveryPerson deliveryPerson = deliveryPersonRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Delivery person by id "+id+" not found")
        );
        return deliveryPerson;
    }

    @Override
    public DeliveryPerson createDeliveryPerson(DeliveryPersonRequest deliveryPersonRequest) {
        return deliveryPersonRepository.save(deliveryPersonRequest.toEntity());
    }

    @Override
    public DeliveryPerson updateDeliveryPersonById(Long id, DeliveryPersonRequest deliveryPersonRequest) {
        getDeliveryPersonById(id);
        return deliveryPersonRepository.save(deliveryPersonRequest.toEntity(id));
    }

    @Override
    public void deleteDeliveryPersonById(Long id) {
        getDeliveryPersonById(id);
        deliveryPersonRepository.deleteById(id);
    }
}
