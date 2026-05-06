package org.backendluxehome.modules.product.dto;

import jakarta.persistence.Cache;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.backendluxehome.modules.category.entity.Category;
import org.backendluxehome.modules.productimages.entity.ProductImages;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,

        @NotNull(message = "100")
        @NotEmpty(message = "100")
        String name,
        String description,
        @NotNull(message = "101")
        @NotEmpty(message = "101")
        BigDecimal price,
        @NotNull(message = "102")
        @NotEmpty(message = "102")
        int stock,
        Long categoryId,
        Long  imageId
        ) {
}
