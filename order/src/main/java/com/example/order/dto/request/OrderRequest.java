package com.example.order.dto.request;

import com.example.order.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class OrderRequest {

    Long id;
    String reference;

    @Positive(message = "Order amount should be positive")
    BigDecimal totalAmount;

    @NotNull(message = "Payment method should be precised")
    PaymentMethod paymentMethod;

    @NotNull(message = "Customer should be present")
    @NotEmpty(message = "Customer should be present")
    @NotBlank(message = "Customer should be present")
    String customerId;

    @NotEmpty(message = "You should at least purchase one product")
    List<PurchaseRequest> products;
}
