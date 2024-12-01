package com.example.demospring.onlinefooddelivery;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Online Food Delivery" , description = "An online food delivery service that connects restaurants with customers for fast, easy, and reliable food ordering.",version = "1.0"))

public class OnlineFoodDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineFoodDeliveryApplication.class, args);
    }

}
