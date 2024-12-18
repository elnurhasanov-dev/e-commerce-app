package com.example.order.client;

import com.example.order.config.FeignConfig;
import com.example.order.dto.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment-client",
        url = "${application.config.payment-url}",
        configuration = FeignConfig.class
)
public interface PaymentClient {

    @PostMapping
    Integer requestOrderPayment(@RequestBody PaymentRequest request);
}
