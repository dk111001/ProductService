package com.deepak.productservice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;
    private String productName;
    private String category;
    private String imageURL;
}
