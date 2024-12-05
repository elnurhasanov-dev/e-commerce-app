package com.example.product.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class ProductRequest {
    Integer id;

    @NotNull(message = "Product name is required")
    String name;

    @NotNull(message = "Product description is required")
    String description;

    @Positive(message = "Available quantity should be positive")
    Double availableQuantity;

    @Positive(message = "Price should be positive")
    BigDecimal price;

    @NotNull(message = "Product category is required")
    Long categoryId;
}
