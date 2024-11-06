package com.ra.ss02.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private Double price;
    @Column(name = "product_stock")
    private Integer stock;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_image")
    private String imageUrl;
    @Column(name = "product_status")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    Category category;
}
