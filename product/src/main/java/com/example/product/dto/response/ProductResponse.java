package com.example.product.dto.response;

import com.example.product.entity.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class ProductResponse {

    Long id;
    String name;
    String description;
    Double availableQuantity;
    BigDecimal price;
    Long categoryId;
    String categoryName;
    String categoryDescription;
    //    @JsonBackReference
//    Category category;
}
