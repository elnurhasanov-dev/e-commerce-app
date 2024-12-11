package com.example.order.mapper;

import com.example.order.dto.request.OrderLineRequest;
import com.example.order.dto.response.OrderLineResponse;
import com.example.order.entity.Order;
import com.example.order.entity.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
//                .id(request.getId())
                .productId(request.getProductId())
                .order(
                        Order.builder()
                                .id(request.getOrderId())
                                .build()
                )
                .quantity(request.getQuantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {

        return OrderLineResponse.builder()
                .id(orderLine.getId())
                .quantity(orderLine.getQuantity())
                .build();
    }
}