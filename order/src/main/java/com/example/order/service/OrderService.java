package com.example.order.service;

import com.example.order.dto.request.OrderRequest;
import com.example.order.dto.response.OrderResponse;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Long createOrder(OrderRequest request) {
        return null;
    }

    public List<OrderResponse> findAllOrders() {
        return null;
    }

    public OrderResponse findById(Long orderId) {
        return null;
    }
}
