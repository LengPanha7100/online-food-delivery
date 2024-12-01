package com.example.demospring.onlinefooddelivery.model.dto.request;
import com.example.demospring.onlinefooddelivery.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequest {
    private String name;
    private String address;
    private String contact;

    public Restaurant toEntity(){
        return new Restaurant(null, this.name,this.address,this.contact,null,null);
    }
    public Restaurant toEntity(Long id){
        return new Restaurant(id, this.name,this.address,this.contact,null,null);
    }
}
