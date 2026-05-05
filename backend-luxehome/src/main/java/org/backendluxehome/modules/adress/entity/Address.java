package org.backendluxehome.modules.adress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backendluxehome.modules.commun.BaseEntity;
import org.backendluxehome.modules.customer.entity.Customer;
import org.backendluxehome.modules.order.entity.Order;
import org.backendluxehome.modules.payment.entity.Payment;
import org.springframework.security.authentication.CachingUserDetailsService;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address extends BaseEntity {

    private String street;
    private String city;
    private String country;
    private int zip;

    @OneToMany(mappedBy = "address")
    private List<Customer> customers;

    @OneToMany(mappedBy = "address")
    private List<Order> orders;
}
