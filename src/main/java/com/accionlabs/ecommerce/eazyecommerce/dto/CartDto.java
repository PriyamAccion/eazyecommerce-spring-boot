package com.accionlabs.ecommerce.eazyecommerce.dto;

import lombok.Data;

@Data
public class CartDto {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
}
