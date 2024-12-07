package com.example.order.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {

    @NotNull(message = "Product is mandatory")
    Long productId;

    @Positive(message = "Quantity is mandatory")
    Double quantity;
}
