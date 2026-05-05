package org.backendluxehome.modules.customer.entity;

import jakarta.persistence.*;
import lombok.*;
import org.backendluxehome.modules.adress.entity.Address;
import org.backendluxehome.modules.cart.entity.Cart;
import org.backendluxehome.modules.order.entity.Order;
import org.backendluxehome.modules.review.entity.Review;
import org.backendluxehome.modules.user.entity.User;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User {

    private String phone;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id" , nullable = false)
    private Address address;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
}
