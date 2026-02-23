package com.accionlabs.ecommerce.eazyecommerce.service;

import com.accionlabs.ecommerce.eazyecommerce.entities.Order;

public interface OrderService {
    Order placeOrder(Long userId);
}
