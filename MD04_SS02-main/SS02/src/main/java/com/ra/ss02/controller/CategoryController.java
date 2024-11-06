package com.ra.ss02.controller;

import com.ra.ss02.model.entity.Category;
import com.ra.ss02.service.category.CategoryService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<> (categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        Category categoryNew = categoryService.save(category);
        return new ResponseEntity<> (categoryNew, HttpStatus.CREATED);
    }
//  EDIT-------------------------------------
    @GetMapping("{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return new ResponseEntity<> (category, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        Category categoryNew = categoryService.save(category);
        return new ResponseEntity<> (categoryNew, HttpStatus.OK);
    }
//    DELETE---------------------------------
    @DeleteMapping("{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}