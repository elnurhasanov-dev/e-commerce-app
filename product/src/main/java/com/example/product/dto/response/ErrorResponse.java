package com.example.product.dto.response;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}