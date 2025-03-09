package org.example.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
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
}
