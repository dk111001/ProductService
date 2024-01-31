package com.deepak.productservice.mapper;

import com.deepak.productservice.dtos.ProductRequestDTO;
import com.deepak.productservice.dtos.ProductResponseDTO;
import com.deepak.productservice.fakestoreapi.FakeStoreProductRequest;
import com.deepak.productservice.fakestoreapi.FakeStoreProductResponse;
import com.deepak.productservice.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static Product getProductFromFakeStoreProduct(FakeStoreProductResponse dto) {
        Product product = new Product();
        product.setId(Long.parseLong(dto.getId()));
        product.setProductName(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setImageURL(dto.getImage());
        //product.setCategory(dto.getCategory());
        return product;
    }

    public static ProductResponseDTO getProductResponseDTOFromProduct(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setProductName(product.getProductName());
        productResponseDTO.setId(product.getId());
        productResponseDTO.setPrice(product.getPrice());
        return productResponseDTO;
    }

    public static FakeStoreProductRequest getFakeStoreProductRequestFromProduct(Product product) {
        FakeStoreProductRequest fakeStoreProductRequest = new FakeStoreProductRequest();
        fakeStoreProductRequest.setTitle(product.getTitle());
        fakeStoreProductRequest.setPrice(product.getPrice());
        //fakeStoreProductRequest.setCategory(product.getCategory());
        fakeStoreProductRequest.setDescription(product.getDescription());
        fakeStoreProductRequest.setImage(product.getImageURL());
        return fakeStoreProductRequest;
    }

    public static Product getProductFromProductRequestDTO(ProductRequestDTO dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setPrice(dto.getPrice());
        product.setImageURL(dto.getImageURL());
        product.setTitle(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        return product;
    }

    public static List<ProductResponseDTO> getProductDTOListFromProducts(List<Product> products) {
        List<ProductResponseDTO> responseDTOS = new ArrayList<>();
        for (Product p : products) {
            responseDTOS.add(getProductResponseDTOFromProduct(p));
        }
        return responseDTOS;
    }
}
