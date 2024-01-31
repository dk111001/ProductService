package com.deepak.productservice.services;

import com.deepak.productservice.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts(int pageNo, int pageSize);
    Product getProductById(Long productId);
    Product createProduct(Product product);

}
