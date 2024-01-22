package com.deepak.productservice.service;

import com.deepak.productservice.fakestoreapi.FakeStoreProductResponse;
import com.deepak.productservice.models.Product;

public interface IProductService {
    Product getProductById(Long productId);
    Product createProduct(Product product);
}
