package com.deepak.productservice.services;

import com.deepak.productservice.models.Product;

public interface IProductService {
    Product getProductById(Long productId);
    Product createProduct(Product product);
}
