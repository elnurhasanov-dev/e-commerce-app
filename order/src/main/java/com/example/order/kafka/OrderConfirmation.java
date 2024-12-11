package com.example.order.kafka;

import com.example.order.dto.response.CustomerResponse;
import com.example.order.dto.response.ProductPurchaseResponse;
import com.example.order.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderConfirmation {

    String orderReference;
    BigDecimal totalAmount;
    PaymentMethod paymentMethod;
    CustomerResponse customer;
    List<ProductPurchaseResponse> products;
}