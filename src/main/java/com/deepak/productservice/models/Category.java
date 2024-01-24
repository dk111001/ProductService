package com.deepak.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseModel{
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}
