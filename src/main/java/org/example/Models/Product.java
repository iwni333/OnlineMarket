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

    @OneToMany(mappedBy = "product",  cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<CartProduct> cartProducts;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public @Size(min = 1, max = 50) String getName() {
        return name;
    }

    public void setName(@Size(min = 1, max = 50) String name) {
        this.name = name;
    }

    public @Size(min = 5, max = 500) String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 5, max = 500) String description) {
        this.description = description;
    }

    public @Min(0) double getPrice() {
        return price;
    }

    public void setPrice(@Min(0) double price) {
        this.price = price;
    }

    public @Min(0) int getQuantity() {
        return quantity;
    }

    public void setQuantity(@Min(0) int quantity) {
        this.quantity = quantity;
    }

    public Category.CategoryType getCategory() {
        return category;
    }

    public void setCategory(Category.CategoryType category) {
        this.category = category;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


}
