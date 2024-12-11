package com.example.order.dto.request;

import com.example.order.dto.response.CustomerResponse;
import com.example.order.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PaymentRequest {

    BigDecimal amount;
    PaymentMethod paymentMethod;
    Long orderId;
    String orderReference;
    CustomerResponse customer;
}
