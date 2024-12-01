package com.example.demospring.onlinefooddelivery.model.dto.request;

import com.example.demospring.onlinefooddelivery.model.Category;
import com.example.demospring.onlinefooddelivery.model.MenuItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private String name;

    public Category toEntity(){
        return new Category(null,this.name,null);
    }

    public Category toEntity(Long id){
        return new Category(id,this.name,null);
    }
}
