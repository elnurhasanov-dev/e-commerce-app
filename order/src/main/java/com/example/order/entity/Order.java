package com.example.order.entity;

import com.example.order.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
@FieldDefaults(level = PRIVATE)
@EntityListeners(AuditingEntityListener.class)

public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    String reference;
    BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;

    String customerId;

    @OneToMany(mappedBy = "order")
    List<OrderLine> orderLines;

    @CreatedDate // @CreationTimestamp
    @Column(updatable = false, nullable = false)
    LocalDateTime createdDate;

    @LastModifiedDate // @UpdateTimestamp
    @Column(insertable = false)
    LocalDateTime lastModifiedDate;
}
