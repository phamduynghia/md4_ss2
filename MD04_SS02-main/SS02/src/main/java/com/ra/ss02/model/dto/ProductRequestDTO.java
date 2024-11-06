package com.ra.ss02.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequestDTO {
   private Long id;
   @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Integer stock;

    private String description;

    private MultipartFile imageUrl;

    private Boolean status;

    private Long categoryId;
}
