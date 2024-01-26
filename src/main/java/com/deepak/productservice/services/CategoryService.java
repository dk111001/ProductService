package com.deepak.productservice.services;

import com.deepak.productservice.models.Category;
import com.deepak.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findCategoriesById(categoryId);
    }
}
