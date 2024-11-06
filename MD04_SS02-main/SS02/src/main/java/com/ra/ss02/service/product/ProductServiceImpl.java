package com.ra.ss02.service.product;

import com.ra.ss02.model.dto.ProductRequestDTO;
import com.ra.ss02.model.entity.Product;
import com.ra.ss02.repository.CategoryRepository;
import com.ra.ss02.repository.ProductRepository;
import com.ra.ss02.service.uploadFile.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UploadFile uploadFile;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.uploadFile = uploadFile;
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        if (productRequestDTO.getId() != null) {
            product.setId(productRequestDTO.getId());
        }
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        product.setStock(productRequestDTO.getStock());
        product.setStatus(productRequestDTO.getStatus());
        product.setCategory(categoryRepository.findById(productRequestDTO.getCategoryId()).orElse(null));
        String image = uploadFile.uploadFile(productRequestDTO.getImageUrl());
        if(productRequestDTO.getId() != null && productRequestDTO.getImageUrl() == null) {
            product.setImageUrl(Objects.requireNonNull(productRepository.findById(productRequestDTO.getId()).orElse(null)).getImageUrl());
        }
        product.setImageUrl(image);
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
       productRepository.deleteById(id);
    }

    @Override
    public Page<Product> paginate(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> searchAndPaginate(String search, Pageable pageable) {
        return productRepository.findAllByNameContaining(search,pageable);
    }

}
