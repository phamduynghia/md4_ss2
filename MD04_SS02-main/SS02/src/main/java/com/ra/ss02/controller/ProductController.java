package com.ra.ss02.controller;

import com.ra.ss02.model.dto.ProductRequestDTO;
import com.ra.ss02.model.entity.Product;
import com.ra.ss02.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
//    @GetMapping
//    public ResponseEntity<List<Product>> findAll() {
//        List<Product> products = productService.findAll();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//  Phan trang
    @GetMapping
    public ResponseEntity<Page<Product>> findAll(
            @RequestParam (name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size,
            @RequestParam(name="search", defaultValue = "")String search,
            @RequestParam(name = "sort", defaultValue = "name") String sort,
            @RequestParam(name = "direction", defaultValue = "direction") String direction
            ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products;
        if (!search.isEmpty()) {
            products = productService.searchAndPaginate(search, pageable);
        } else {
            products = productService.paginate(pageable);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> save(@ModelAttribute ProductRequestDTO productRequestDTO) {
        return new ResponseEntity<>(productService.save(productRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @ModelAttribute ProductRequestDTO productRequestDTO) {
//        product.setId(id);
        return new ResponseEntity<>(productService.save(productRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
