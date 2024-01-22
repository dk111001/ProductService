package com.deepak.productservice.controller;

import com.deepak.productservice.dto.CreateProductRequestDTO;
import com.deepak.productservice.fakestoreapi.FakeStoreProductResponse;
import com.deepak.productservice.service.IProductService;
import com.deepak.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/products") // dispatcher servlet
public class ProductController {
    private IProductService productService; // dependency inversion principle
    public ProductController(IProductService productService) {
        this.productService = productService; // not creating object
    }
    @GetMapping("")
    public String getAllProducts(){
        return "all products...";
    }

    @PostMapping("")
    public String createProduct(@RequestBody CreateProductRequestDTO dto) {
        return "product created... " + dto.getProductName();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<FakeStoreProductResponse> getProductById(@PathVariable("productId") Long productId) {
        try {
            FakeStoreProductResponse data = productService.getProductById(productId);
            ResponseEntity<FakeStoreProductResponse> response;
            // for headers there is different type Response Entity
            if (Objects.isNull(data)) {
                response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                response = new ResponseEntity<>(data, HttpStatus.OK);
            }
            return response;
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
