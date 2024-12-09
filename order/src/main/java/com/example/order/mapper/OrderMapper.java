package com.example.order.mapper;

import com.example.order.dto.request.OrderRequest;
import com.example.order.dto.response.OrderResponse;
import com.example.order.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order buildOrderEntity(OrderRequest request) {
        if (request == null) {
            return null;
        }
        return Order.builder()
                .id(request.getId())
                .reference(request.getReference())
                .paymentMethod(request.getPaymentMethod())
                .customerId(request.getCustomerId())
                .build();
    }

    public OrderResponse buildOrderResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}