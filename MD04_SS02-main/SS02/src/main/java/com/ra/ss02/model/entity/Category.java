package com.ra.ss02.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "category_description")
    private String description;
    @Column(name = "category_status")
    private Boolean status;
    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    Set<Product> products;
}
