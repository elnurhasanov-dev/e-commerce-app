package com.example.product.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@FieldDefaults(level = PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String name;
    String description;
    Double availableQuantity;
    BigDecimal price;

    @ManyToOne (fetch = LAZY)
    @JoinColumn(name = "category_id")
    Category category;
}
