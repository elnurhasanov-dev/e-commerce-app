package com.example.order.controller;

import com.example.order.dto.response.OrderLineResponse;
import com.example.order.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("/order/{order-id}")
    public List<OrderLineResponse> findByOrderId(@PathVariable("order-id") Long orderId) {
        return orderLineService.findAllByOrderId(orderId);
    }
}