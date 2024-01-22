package com.deepak.productservice.service;

import com.deepak.productservice.fakestoreapi.FakeStoreProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService implements IProductService {
    private RestTemplateBuilder templateBuilder;
    private final RestTemplate template;
    @Autowired
    public ProductService(RestTemplateBuilder templateBuilder) {
        template = templateBuilder.build();
    }
    @Override
    public FakeStoreProductResponse getProductById(Long productId) {
        FakeStoreProductResponse dto = template.
                                        getForEntity("https://fakestoreapi.com/products/{productId}",
                                        FakeStoreProductResponse.class, productId).getBody();
        return dto;
    }
}
