package com.example.product.mapper;

import com.example.product.dto.request.ProductRequest;
import com.example.product.dto.response.ProductPurchaseResponse;
import com.example.product.dto.response.ProductResponse;
import com.example.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface ProductMapper {

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "categoryDescription", source = "category.description")
    ProductResponse buildProductResponse(Product entity);

    @Mapping(target = "id", ignore = true)
    Product buildProductEntity(ProductRequest request);

    ProductPurchaseResponse buildProductPurchaseResponse(Product product, double quantity);

}
