package com.deepak.productservice.controller;

import com.deepak.productservice.dto.CreateProductRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products") // dispatcher servlet
public class ProductController {
    @GetMapping("")
    public String getAllProducts(){
        return "all products...";
    }

    @PostMapping("")
    public String createProduct(@RequestBody CreateProductRequestDTO dto) {
        return "product created... " + dto.getProductName();
    }

    @GetMapping("/{productId}")
    public String getProductById(@PathVariable("productId") Integer productId) {
        return "user is..." + productId;
    }
}
