package com.example.payment.mapper;

import com.example.payment.dto.request.PaymentRequest;
import com.example.payment.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest request) {
        if (request == null) {
            return null;
        }
        return Payment.builder()
                .id(request.getId())
                .paymentMethod(request.getPaymentMethod())
                .amount(request.getTotalAmount())
                .orderId(request.getOrderId())
                .build();
    }
}
