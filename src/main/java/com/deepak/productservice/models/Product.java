package com.deepak.productservice.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;
    private String productName;
    private String specifications;
    private String sku;
    // Product : Category
    @ManyToOne // no mapped by allowed
    @JoinColumn(name = "category_id")
    private Category category;
    private String imageURL;
}
