package com.example.order.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class OrderLineResponse {
    Long id;
    Long orderId;
    Long productId;
    Double quantity;
}