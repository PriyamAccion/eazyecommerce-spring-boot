package com.accionlabs.ecommerce.eazyecommerce.service;

import com.accionlabs.ecommerce.eazyecommerce.dto.OrderRequestDto;
import com.accionlabs.ecommerce.eazyecommerce.dto.OrderResponseDto;

public interface OrderService {
    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);
}
