package org.backendluxehome.modules.review.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.backendluxehome.modules.commun.BaseEntity;
import org.backendluxehome.modules.customer.entity.Customer;
import org.backendluxehome.modules.product.entity.Product;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class Review extends BaseEntity {

    private Double rating;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

}
