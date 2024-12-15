package com.example.payment.service;

import com.example.payment.dto.request.PaymentNotificationRequest;
import com.example.payment.dto.request.PaymentRequest;
import com.example.payment.kafka.NotificationProducer;
import com.example.payment.mapper.PaymentMapper;
import com.example.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper mapper;
    private final PaymentRepository paymentRepository;
    private final NotificationProducer notificationProducer;

    public Long createPayment(PaymentRequest request) {
        var payment = paymentRepository.save(mapper.toPayment(request));

        notificationProducer.sendNotification(PaymentNotificationRequest.builder()
                .orderReference(request.getOrderReference())
                .totalAmount(request.getTotalAmount())
                .paymentMethod(request.getPaymentMethod())
                .customerFirstname(request.getCustomer().firstname())
                .customerLastname(request.getCustomer().lastname())
                .customerEmail(request.getCustomer().email())
                .build());

        return payment.getId();
    }
}
