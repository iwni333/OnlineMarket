package org.example.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Id")
    private long orderId;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "orderDate", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "totalPrice", nullable = false)
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "orderStatus", nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "address", nullable = false)
    private String shippingAddress;

    public enum OrderStatus {
        PENDING,
        FAILED,
        ON_HOLD,
        COMPLETED,
        PROCESSING,
        CANCELED,
        REFUNDED,
        TRASH
    }
}
