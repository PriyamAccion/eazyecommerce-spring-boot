package com.accionlabs.ecommerce.eazyecommerce.mapper;

import com.accionlabs.ecommerce.eazyecommerce.dto.OrderDto;
import com.accionlabs.ecommerce.eazyecommerce.entities.Order;

public final class OrderMapper {

    private OrderMapper() {
    }

    public static OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setUserId(order.getUser().getId());
        orderDto.setTotalAmount(order.getTotalAmount());
        orderDto.setOrderDate(order.getOrderDate());
        return orderDto;
    }
}
