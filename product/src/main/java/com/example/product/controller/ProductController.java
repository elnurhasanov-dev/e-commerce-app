package com.example.product.controller;

import com.example.product.dto.request.ProductPurchaseRequest;
import com.example.product.dto.response.ProductPurchaseResponse;
import com.example.product.dto.request.ProductRequest;
import com.example.product.dto.response.ProductResponse;
import com.example.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createProduct(@RequestBody @Valid ProductRequest request) {
        return productService.createProduct(request);
    }

    @PostMapping("/purchase")
    @ResponseStatus(OK)
    public List<ProductPurchaseResponse> purchaseProducts(@RequestBody List<ProductPurchaseRequest> request) {
        return productService.purchaseProducts(request);
    }

    @GetMapping("/{product-id}")
    public ProductResponse findById(@PathVariable("product-id") Long productId) {
        return productService.findById(productId);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }
}
