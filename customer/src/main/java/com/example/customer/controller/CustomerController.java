package com.example.customer.controller;

import com.example.customer.dto.request.CustomerRequest;
import com.example.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public String createCustomer(@RequestBody @Valid CustomerRequest request) {
        return service.createCustomer(request);
    }

    @PutMapping
    @ResponseStatus(OK)
    public void updateCustomer(@RequestBody @Valid CustomerRequest request) {
        service.updateCustomer(request);
    }
}
