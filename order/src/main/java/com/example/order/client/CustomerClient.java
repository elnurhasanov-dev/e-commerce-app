package com.example.order.client;

import com.example.order.config.FeignConfig;
import com.example.order.dto.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@FeignClient(
        name = "customer-client",
        url = "${application.config.customer-url}",
        configuration = FeignConfig.class
)
public interface CustomerClient {

    @GetMapping("/{customer-id}")
    CustomerResponse findCustomerById(@PathVariable("customer-id") String customerId);
}
