package com.accionlabs.ecommerce.eazyecommerce.mapper;

import com.accionlabs.ecommerce.eazyecommerce.dto.OrderResponseDto;
import com.accionlabs.ecommerce.eazyecommerce.entities.Order;

public final class OrderMapper {

    private OrderMapper() {
    }

    public static OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setUserId(order.getUser().getId());
        orderResponseDto.setTotalAmount(order.getTotalAmount());
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setStatus(order.getStatus());
        return orderResponseDto;
    }
}
