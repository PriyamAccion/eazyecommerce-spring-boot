package com.accionlabs.ecommerce.eazyecommerce.dto;

import com.accionlabs.ecommerce.eazyecommerce.entities.OrderStatus;
import lombok.Data;

@Data
public class CartResponseDto {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private OrderStatus orderStatus;

    public void setStatus(OrderStatus status) {
        this.orderStatus = status;
    }
}
