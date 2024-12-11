package com.example.notification.kafka.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentConfirmation {

    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private Long orderId;
    private String orderReference;
    private String customerFirstname;
    private String customerLastname;
    private String customerEmail;
}
