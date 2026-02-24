package com.accionlabs.ecommerce.eazyecommerce.dto;

import com.accionlabs.ecommerce.eazyecommerce.entities.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponseDto {
    private Long id;
    private Long userId;
    private Double totalAmount;
    private LocalDateTime orderDate;
    private OrderStatus status;
}

