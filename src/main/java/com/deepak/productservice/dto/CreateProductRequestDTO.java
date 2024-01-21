package com.deepak.productservice.dto;

import lombok.Data;
@Data// all args constructor, to string method, getter and setter
public class CreateProductRequestDTO {
    private String productName;
    private String category;
    private String imageURL;
    private Double price;
}
