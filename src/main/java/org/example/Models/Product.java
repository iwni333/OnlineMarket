package org.example.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_Id")
    private long productId;

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 1, max = 50)
    private String name;

    @Column(name = "description", nullable = false)
    @Size(min = 5, max = 500)
    private String description;

    @Column(name = "price", nullable = false)
    @Min(0)
    private double price;

    @Column(name = "quantity", nullable = false)
    @Min(0)
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category.CategoryType category;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;


}
