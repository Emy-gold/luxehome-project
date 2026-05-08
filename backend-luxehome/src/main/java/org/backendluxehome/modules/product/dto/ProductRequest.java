package org.backendluxehome.modules.product.dto;

import jakarta.persistence.Cache;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
        @Positive(message = "price must be > 0")
        BigDecimal price,
        @NotNull(message = "102")
        @PositiveOrZero(message = "stock must be >= 0")
        int stock,
        Integer categoryId,
        Integer imageId

        ) {
}
