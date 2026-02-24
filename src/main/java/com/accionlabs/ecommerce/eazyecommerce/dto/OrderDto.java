package com.accionlabs.ecommerce.eazyecommerce.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long id;
    private Long userId;
    private Double totalAmount;
    private LocalDateTime orderDate;
}