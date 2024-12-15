package com.example.payment.dto.request;

import com.example.payment.constant.PaymentMethod;
import com.example.payment.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private Long id;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private Long orderId;
    private String orderReference;
    private Customer customer;
}
