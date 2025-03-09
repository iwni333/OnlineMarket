package org.example.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_Id")
    private long cartId;

    @OneToOne
    @JoinColumn(name = "user_id",  nullable = false)
    private User user;


    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @Column(name = "quantity",  nullable = false)
    @Min(0)
    private int quantity;

    @Column(name = "price",  nullable = false)
    @Min(0)
    private double price;
}
