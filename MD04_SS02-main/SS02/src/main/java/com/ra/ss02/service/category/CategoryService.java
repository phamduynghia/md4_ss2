package com.ra.ss02.service.category;

import com.ra.ss02.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    void deleteById(Long id);

}
