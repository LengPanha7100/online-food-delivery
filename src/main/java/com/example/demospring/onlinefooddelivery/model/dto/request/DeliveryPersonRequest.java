package com.example.demospring.onlinefooddelivery.model.dto.request;

import com.example.demospring.onlinefooddelivery.model.DeliveryPerson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPersonRequest {
    private String name;
    private String contactName;
    private String vehicleType;

    public DeliveryPerson toEntity(){
        return new DeliveryPerson(null,this.name,this.contactName,this.vehicleType,null);
    }
    public DeliveryPerson toEntity(Long id){
        return new DeliveryPerson(id,this.name,this.contactName,this.vehicleType,null);
    }
}
