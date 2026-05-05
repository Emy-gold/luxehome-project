package org.backendluxehome.modules.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backendluxehome.modules.adress.entity.Address;
import org.backendluxehome.modules.commun.BaseEntity;
import org.backendluxehome.modules.customer.entity.Customer;
import org.backendluxehome.modules.orderitem.entity.OrderItem;
import org.backendluxehome.modules.payment.entity.Payment;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {

    private String status;
    private BigDecimal totalAmount;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;
}
