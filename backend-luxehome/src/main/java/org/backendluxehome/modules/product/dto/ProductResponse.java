package org.backendluxehome.modules.product.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private String categoryName;
    private String imageUrl;
    private double rating;

}
