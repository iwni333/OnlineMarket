package org.example.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartProduct_id")
    private long cartProductId;
    @ManyToOne
    @JoinColumn(name = "cart_id",   nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id",   nullable = false)
    private Product product;

    @Column(name = "quantity",  nullable = false)
    @Min(0)
    private int quantity;

    @Column(name = "price", nullable = false)
    @Min(0)
    private double price;

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public @Min(0) int getQuantity() {
        return quantity;
    }

    public void setQuantity(@Min(0) int quantity) {
        this.quantity = quantity;
    }

    public @Min(0) double getPrice() {
        return price;
    }

    public void setPrice(@Min(0) double price) {
        this.price = price;
    }
}
