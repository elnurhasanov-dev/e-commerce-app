package com.example.customer.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class ExceptionResponse {

    Integer status;
    String error;
    String message;
    String path;
    LocalDateTime timestamp;
}
