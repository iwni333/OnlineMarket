package org.example.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderItem_id")
    private long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id",   nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity",  nullable = false)
    @Min(0)
    private int quantity;

    @Column(name = "price", nullable = false)
    @Min(0)
    private double price;


    public long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
