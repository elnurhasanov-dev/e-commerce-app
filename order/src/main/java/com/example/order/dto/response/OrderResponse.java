package com.example.order.dto.response;

import com.example.order.enums.PaymentMethod;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class OrderResponse {
    Long id;
    String reference;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerId;
}
