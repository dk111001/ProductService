package com.deepak.productservice.controllers;

import com.deepak.productservice.dtos.ProductRequestDTO;
import com.deepak.productservice.dtos.ProductResponseDTO;
import com.deepak.productservice.mapper.ProductMapper;
import com.deepak.productservice.models.Product;
import com.deepak.productservice.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products") // dispatcher servlet
public class ProductController {
    private final IProductService productService; // dependency inversion principle
    public ProductController(IProductService productService) {
        this.productService = productService; // not creating object
    }
    @GetMapping("")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(@RequestParam(defaultValue = "0") int pageNo,
                                                        @RequestParam(defaultValue = "10") int pageSize){
        List<Product> products = productService.getAllProducts(pageNo, pageSize);
        return new ResponseEntity<>(ProductMapper.getProductDTOListFromProducts(products), HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        try {
            Product data = productService.createProduct(ProductMapper.getProductFromProductRequestDTO(productRequestDTO));
            ResponseEntity<ProductResponseDTO> response;
            // for headers there is different type Response Entity
            if (Objects.isNull(data)) {
                response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                response = new ResponseEntity<>(ProductMapper.getProductResponseDTOFromProduct(data), HttpStatus.OK);
            }
            return response;
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("productId") Long productId) {
        try {
            Product data = productService.getProductById(productId);
            ResponseEntity<ProductResponseDTO> response;
            // for headers there is different type Response Entity
            if (Objects.isNull(data)) {
                response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                response = new ResponseEntity<>(ProductMapper.getProductResponseDTOFromProduct(data), HttpStatus.OK);
            }
            return response;
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
