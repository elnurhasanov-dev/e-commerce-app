package com.example.product.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
@FieldDefaults(level = PRIVATE)
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String name;
    String description;

    @OneToMany(mappedBy = "category", cascade = REMOVE)
    List<Product> products;
}