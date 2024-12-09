package com.example.order.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class OrderLineRequest {

    Long id;
    Long orderId;
    Long productId;
    Double quantity;
}
