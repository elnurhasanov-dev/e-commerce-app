package com.example.order.service;

import com.example.order.client.CustomerClient;
import com.example.order.client.PaymentClient;
import com.example.order.client.ProductClient;
import com.example.order.dto.request.OrderLineRequest;
import com.example.order.dto.request.OrderRequest;
import com.example.order.dto.request.PaymentRequest;
import com.example.order.dto.request.PurchaseRequest;
import com.example.order.dto.response.OrderResponse;
import com.example.order.exceptions.NotFoundException;
import com.example.order.kafka.OrderConfirmation;
import com.example.order.kafka.OrderProducer;
import com.example.order.mapper.OrderMapper;
import com.example.order.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final PaymentClient paymentClient;
    private final OrderLineService orderLineService;
    private final OrderMapper mapper;
    private final OrderProducer orderProducer;

    public Long createOrder(OrderRequest request) {

        var customer = customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Cannot create order:: No customer exists with the provided ID"));

        var purchasedProducts = productClient.purchaseProducts(request.getProducts());

        var order = orderRepository.save(mapper.buildOrderEntity(request));

        for (PurchaseRequest purchaseRequest : request.getProducts()) {
            orderLineService.saveOrderLine(OrderLineRequest.builder()
                    .id(null)
                    .orderId(order.getId())
                    .productId(purchaseRequest.getProductId())
                    .quantity(purchaseRequest.getQuantity())
                    .build());
        }

        var paymentRequest = PaymentRequest.builder()
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .orderId(order.getId())
                .orderReference(order.getReference())
                .customer(customer)
                .build();
        paymentClient.requestOrderPayment(paymentRequest);

        orderProducer.sendOrderConfirmation(OrderConfirmation.builder()
                .orderReference(request.getReference())
                .totalAmount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .customer(customer)
                .products(purchasedProducts)
                .build());

        return order.getId();
    }


    public List<OrderResponse> findAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(mapper::buildOrderResponse)
                .collect(Collectors.toList());
    }


    public OrderResponse findById(Long orderId) {
        return orderRepository.findById(orderId).map(mapper::buildOrderResponse)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("No order found with the provided ID: %d", orderId))
                );
    }
}
