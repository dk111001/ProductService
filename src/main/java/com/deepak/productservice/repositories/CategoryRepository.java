package com.deepak.productservice.repositories;

import com.deepak.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoriesById(Long id);

    @Query(value = "select c from Category c where c.id=?1") // here ?1 will be replace by name similarly we can add ?2 for another var
    Category findByName(String name);
}
