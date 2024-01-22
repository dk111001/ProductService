package com.deepak.productservice.fakestoreapi;

import lombok.Data;

@Data
public class FakeStoreProductRequest {
    String title;
    Double price;
    String description;
    String image;
    String category;
}
