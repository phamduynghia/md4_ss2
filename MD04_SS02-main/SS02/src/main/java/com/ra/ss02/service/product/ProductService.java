package com.ra.ss02.service.product;

import com.ra.ss02.model.dto.ProductRequestDTO;
import com.ra.ss02.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(ProductRequestDTO productRequestDTO);
    void deleteById(Long id);
    Page<Product> paginate(Pageable pageable);


    Page<Product> searchAndPaginate(String search, Pageable pageable);
}
