package org.backendluxehome.modules.product.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.backendluxehome.modules.cartitem.entity.CartItem;
import org.backendluxehome.modules.category.entity.Category;
import org.backendluxehome.modules.commun.BaseEntity;
import org.backendluxehome.modules.orderitem.entity.OrderItem;
import org.backendluxehome.modules.productimages.entity.ProductImages;


import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductImages image;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

}
