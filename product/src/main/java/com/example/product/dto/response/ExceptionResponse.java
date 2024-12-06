package com.example.product.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private Integer statusCode;
    private String message;
    private String error;
    private String path;
    private LocalDateTime timestamp;
}