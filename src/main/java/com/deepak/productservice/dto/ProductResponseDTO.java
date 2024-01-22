package com.deepak.productservice.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ProductResponseDTO {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String productName;
}
