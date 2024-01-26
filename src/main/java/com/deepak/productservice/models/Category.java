package com.deepak.productservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseModel{
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //similarly we can add for products // cascading
    // any changes made in category will reflect in Category table
    // also we can add this in category table
    private List<Product> products;
}
