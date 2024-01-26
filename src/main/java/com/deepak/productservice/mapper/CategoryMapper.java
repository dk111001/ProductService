package com.deepak.productservice.mapper;

import com.deepak.productservice.dtos.CategoryRequestDTO;
import com.deepak.productservice.dtos.CategoryResponseDTO;
import com.deepak.productservice.fakestoreapi.FakeStoreProductResponse;
import com.deepak.productservice.models.Category;
import com.deepak.productservice.models.Product;

public class CategoryMapper {
    public static Category getCategoryFromCategoryRequestDTO(CategoryRequestDTO dto) {
        Category category = new Category();
        category.setDescription(dto.getDescription());
        category.setName(dto.getName());
        return category;
    }

    public static CategoryResponseDTO getCategoryResponseDTOFromCategory(Category category) {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setName(category.getName());
        categoryResponseDTO.setDescription(category.getDescription());
        categoryResponseDTO.setId(category.getId());
        return categoryResponseDTO;
    }
}
