package com.example.order.client.decoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionMessage {

    private Integer statusCode;
    private String error;
    private String message;
    private String path;
    private String timestamp;
}
