package org.example.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_Id")
    private long categoryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private CategoryType name;

    @Column(name = "description", nullable = false)
    @Size(min = 5, max = 500)
    private String description;


    public enum CategoryType {
        ELECTRONICS,
        CLOTHING,
        FOOD,
        HOME,
        OTHER
    }
}
