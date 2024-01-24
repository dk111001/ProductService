package com.deepak.productservice.repositories;

import com.deepak.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);
}
