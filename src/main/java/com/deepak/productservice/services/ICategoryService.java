package com.deepak.productservice.services;

import com.deepak.productservice.models.Category;

public interface ICategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Long categoryId);
}
