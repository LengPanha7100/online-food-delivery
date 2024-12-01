package com.example.demospring.onlinefooddelivery.model.dto.request;
import com.example.demospring.onlinefooddelivery.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String name;
    private String email;
    private String quantity;

    public Customer toEntity(){
        return new Customer(null,this.name,this.email,this.quantity,null,null,null);
    }
    public Customer toEntity(Long id){
        return new Customer(id,this.name,this.email,this.quantity,null,null,null);
    }

}
