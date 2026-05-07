package org.backendluxehome.modules.product.mapper;

import org.backendluxehome.modules.product.dto.ProductRequest;
import org.backendluxehome.modules.product.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest request){
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .stock(request.stock())
                .build();

    }
}
