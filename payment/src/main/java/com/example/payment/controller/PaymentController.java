package com.example.payment.controller;

import com.example.payment.dto.request.PaymentRequest;
import com.example.payment.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(OK)
    public Long createPayment(@RequestBody @Valid PaymentRequest request) {
        return paymentService.createPayment(request);
    }
}
