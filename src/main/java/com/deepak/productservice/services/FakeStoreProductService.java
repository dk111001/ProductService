package com.deepak.productservice.services;

import com.deepak.productservice.fakestoreapi.FakeStoreProductRequest;
import com.deepak.productservice.fakestoreapi.FakeStoreProductResponse;
import com.deepak.productservice.mapper.ProductMapper;
import com.deepak.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {
    private RestTemplateBuilder templateBuilder;
    private final RestTemplate template;
    @Autowired
    public FakeStoreProductService(RestTemplateBuilder templateBuilder) {
        template = templateBuilder.build();
    }

    @Override
    public List<Product> getAllProducts(int pageNo, int pageSize) {
        return null;
    }
    @Override
    public Product getProductById(Long productId) {
        System.out.println("Yeah");
        FakeStoreProductResponse dto = template.
                                        getForObject("https://fakestoreapi.com/products/{productId}",
                                        FakeStoreProductResponse.class, productId);
        return ProductMapper.getProductFromFakeStoreProduct(dto);
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductRequest fakeStoreProductRequest = ProductMapper.getFakeStoreProductRequestFromProduct(product);
        FakeStoreProductResponse dto = template.
                                        postForObject("https://fakestoreapi.com/products",
                                                fakeStoreProductRequest,
                                                FakeStoreProductResponse.class);
        return ProductMapper.getProductFromFakeStoreProduct(dto);
    }
}
