package com.example.order.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "oder_line")
@FieldDefaults(level = PRIVATE)
public class OrderLine {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    Long productId;
    Double quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;
}
