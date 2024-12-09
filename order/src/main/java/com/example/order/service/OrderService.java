package com.example.order.service;

import com.example.order.client.CustomerClient;
import com.example.order.client.ProductClient;
import com.example.order.dto.request.OrderLineRequest;
import com.example.order.dto.request.OrderRequest;
import com.example.order.dto.request.PurchaseRequest;
import com.example.order.dto.response.OrderResponse;
import com.example.order.exceptions.BusinessException;
import com.example.order.mapper.OrderMapper;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final OrderLineService orderLineService;
    private final OrderMapper mapper;

    public Long createOrder(OrderRequest request) {

        var customer = customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID"));

        productClient.purchaseProducts(request.getProducts());

        var order = orderRepository.save(mapper.buildOrderEntity(request));

        for (PurchaseRequest purchaseRequest : request.getProducts()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.getProductId(),
                            purchaseRequest.getQuantity()
                    )
            );
        }

        return null;
    }

    public List<OrderResponse> findAllOrders() {
        return null;
    }

    public OrderResponse findById(Long orderId) {
        return null;
    }
}
