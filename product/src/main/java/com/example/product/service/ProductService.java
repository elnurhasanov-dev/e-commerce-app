package com.example.product.service;

import com.example.product.dto.request.ProductPurchaseRequest;
import com.example.product.dto.request.ProductRequest;
import com.example.product.dto.response.ProductPurchaseResponse;
import com.example.product.dto.response.ProductResponse;
import com.example.product.entity.Product;
import com.example.product.exception.NotFoundException;
import com.example.product.exception.ProductPurchaseException;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Long createProduct(ProductRequest request) {
        var product = productMapper.buildProductEntity(request);
        return productRepository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::getProductId)
                .toList();

        var storedProducts = productRepository.findAllByIdInOrderById(productIds);

        if (storedProducts.size() < productIds.size()) {
            throw new NotFoundException("One or more products does not exist");
        }

        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
                .toList();

        List<ProductPurchaseResponse> purchaseProducts =  new ArrayList<ProductPurchaseResponse>();

        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);

            if (product.getAvailableQuantity() < productRequest.getQuantity()) {
                throw new ProductPurchaseException(String.format(
                        "Insufficient stock quantity for product with ID: %s ", productRequest.getProductId()));
            }

            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.getQuantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchaseProducts.add(productMapper.buildProductPurchaseResponse(product, productRequest.getQuantity()));
        }

        return purchaseProducts;
    }

    public ProductResponse findById(Long productId) {
        var product = fetchProductByIdIfExist(productId);
//        System.out.println(product.getCategory().getDescription());
//        System.out.println(product.getCategory().getName());
        return productMapper.buildProductResponse(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::buildProductResponse)
                .toList();
    }

    private Product fetchProductByIdIfExist(Long productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException(String.format("Product not found with ID: %s", productId))
        );
    }
}
