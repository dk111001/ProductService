package com.deepak.productservice.service;

import com.deepak.productservice.fakestoreapi.FakeStoreProductResponse;

public interface IProductService {
    FakeStoreProductResponse getProductById(Long productId);
}
