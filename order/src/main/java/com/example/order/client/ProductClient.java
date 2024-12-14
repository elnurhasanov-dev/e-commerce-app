package com.example.order.client;

import com.example.order.config.FeignConfig;
import com.example.order.dto.request.PurchaseRequest;
import com.example.order.dto.response.ProductPurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "product-client",
        url = "${application.config.product-url}",
        configuration = FeignConfig.class
)
public interface ProductClient {

    @PostMapping("/purchase")
    List<ProductPurchaseResponse> purchaseProducts(@RequestBody List<PurchaseRequest> purchase);
}
