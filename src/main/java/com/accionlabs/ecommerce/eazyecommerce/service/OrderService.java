package com.accionlabs.ecommerce.eazyecommerce.service;

import com.accionlabs.ecommerce.eazyecommerce.dto.OrderDto;
import com.accionlabs.ecommerce.eazyecommerce.entities.Order;

public interface OrderService {
    OrderDto placeOrder(Long userId);
}
