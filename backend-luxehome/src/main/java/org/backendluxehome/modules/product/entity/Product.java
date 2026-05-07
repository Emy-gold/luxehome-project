package org.backendluxehome.modules.product.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.backendluxehome.modules.cartitem.entity.CartItem;
import org.backendluxehome.modules.category.entity.Category;
import org.backendluxehome.modules.commun.BaseEntity;
import org.backendluxehome.modules.orderitem.entity.OrderItem;
import org.backendluxehome.modules.productimages.entity.ProductImages;
import org.backendluxehome.modules.review.entity.Review;
import org.backendluxehome.modules.user.entity.User;


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

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductImages image;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy="product")
    private List<Review> reviews;

    @Transient
    public double getRating(){
        if(reviews == null || reviews.isEmpty()){
            return 0.0;
        }

        var rate = this.reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
        double roundedRate = Math.round(rate * 10.0) / 10.0;
        return  roundedRate;
    }

}
