package com.deepak.productservice.controllers;

import com.deepak.productservice.dtos.ProductRequestDTO;
import com.deepak.productservice.dtos.ProductResponseDTO;
import com.deepak.productservice.mapper.ProductMapper;
import com.deepak.productservice.models.Product;
import com.deepak.productservice.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private IProductService productService;

    @Test
    public void Test_GetProduct_ReturnProduct() {
        //Arrange
        Product product = new Product();
        product.setPrice(1000D);
        product.setTitle("Iphone15");
        when(productService.getProductById(any(Long.class))).thenReturn(product);

        //Act
        ResponseEntity<ProductResponseDTO> productResponseEntity = productController.getProductById(1L);

        //Assert
        assertNotNull(productResponseEntity);
        assertEquals(1000D,productResponseEntity.getBody().getPrice());
        assertEquals("Iphone15",productResponseEntity.getBody().getTitle());
        verify(productService,times(1)).getProductById(1L);
    }

    @Test
    public void Test_CreateProduct_ReturnProduct() {
        //Arrange
        Product product = new Product();
        product.setPrice(1000D);
        product.setTitle("Iphone15");
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        //Act
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Iphone15");
        productRequestDTO.setPrice(1000D);
        ResponseEntity<ProductResponseDTO> productResponseEntity = productController.createProduct(productRequestDTO);

        //Assert
        assertNotNull(productResponseEntity);
        assertEquals(1000D,productResponseEntity.getBody().getPrice());
        assertEquals("Iphone15",productResponseEntity.getBody().getTitle());
    }

}