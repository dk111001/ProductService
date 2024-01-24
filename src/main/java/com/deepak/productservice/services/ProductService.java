package com.deepak.productservice.services;

import com.deepak.productservice.models.Product;
import com.deepak.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProductService implements IProductService{
    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(Long productId){
        return productRepository.findProductById(productId);
    }
    @Override
    public Product createProduct(Product product){
        System.out.println(product.getCategory().getName());
        Product savedProduct = productRepository.save(product);
        return getProductById(savedProduct.getId()); //getProductById(savedProduct.getId());
    }
}
