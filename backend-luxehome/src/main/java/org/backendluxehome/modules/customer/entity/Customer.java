package org.backendluxehome.modules.customer.entity;

import jakarta.persistence.*;
import lombok.*;
import org.backendluxehome.modules.cart.entity.Cart;
import org.backendluxehome.modules.user.entity.User;

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
}
