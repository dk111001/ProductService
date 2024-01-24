package com.deepak.productservice.dtos;

import com.deepak.productservice.models.Category;
import lombok.Data;
@Data// all args constructor, to string method, getter and setter
public class ProductRequestDTO {
    private String productName;
    private Category category;
    private String imageURL;
    private Double price;
    private String description;
}
