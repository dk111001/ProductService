package com.deepak.productservice.controllers;

import com.deepak.productservice.dtos.CategoryRequestDTO;
import com.deepak.productservice.dtos.CategoryResponseDTO;
import com.deepak.productservice.mapper.CategoryMapper;
import com.deepak.productservice.models.Category;
import com.deepak.productservice.services.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryService categoryService; // dependency inversion principle
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService; // not creating object
    }
    @GetMapping("")
    public String getAllCategories(){
        return "all categories...";
    }

    @PostMapping("")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        try {
            Category data = categoryService.createCategory(CategoryMapper.getCategoryFromCategoryRequestDTO(categoryRequestDTO));
            ResponseEntity<CategoryResponseDTO> response;
            // for headers there is different type Response Entity
            if (Objects.isNull(data)) {
                response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                response = new ResponseEntity<>(CategoryMapper.getCategoryResponseDTOFromCategory(data), HttpStatus.OK);
            }
            return response;
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("categoryId") Long categoryId) {
        try {
            Category data = categoryService.getCategoryById(categoryId);
            ResponseEntity<CategoryResponseDTO> response;
            // for headers there is different type Response Entity
            if (Objects.isNull(data)) {
                response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                response = new ResponseEntity<>(CategoryMapper.getCategoryResponseDTOFromCategory(data), HttpStatus.OK);
            }
            return response;
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
