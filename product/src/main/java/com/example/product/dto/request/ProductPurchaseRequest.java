package com.example.product.dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPurchaseRequest {

    @NotNull(message = "Product is mandatory")
    Integer productId;

    @Positive(message = "Quantity is mandatory")
    Double quantity;
}
