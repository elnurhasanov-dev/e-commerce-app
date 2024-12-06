package com.example.order.controller;

import com.example.order.dto.request.OrderRequest;
import com.example.order.dto.response.OrderResponse;
import com.example.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Long createOrder(@RequestBody @Valid OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping
    public List<OrderResponse> findAll() {
        return orderService.findAllOrders();
    }

    @GetMapping("/{order-id}")
    public OrderResponse findById(@PathVariable("order-id") Integer orderId) {
        return orderService.findById(orderId);
    }
}
