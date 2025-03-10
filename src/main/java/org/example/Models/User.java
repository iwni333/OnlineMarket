package org.example.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name ="\"User\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "username", unique = true, nullable = false)
    @Size(min = 4, max = 30)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @Email
    private String email;

    @Column(name = "password", unique = true, nullable = false)
    @Size(min = 6, max = 50)
    private String password;

    @Column(name = "firstName", nullable = false)
    @Size(max = 30)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @Size(max = 30)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    public enum Role {
        ADMIN,
        USER,
    }

    public User() {}

    public User(int id,String username, String email, String password, String firstName, String lastName, Role role) {
        this.userId = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public @Size(min = 4, max = 30) String getUsername() {
        return username;
    }

    public void setUsername(@Size(min = 4, max = 30) String username) {
        this.username = username;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @Size(min = 6, max = 50) String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 6, max = 50) String password) {
        this.password = password;
    }

    public @Size(max = 30) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Size(max = 30) String firstName) {
        this.firstName = firstName;
    }

    public @Size(max = 30) String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(max = 30) String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
