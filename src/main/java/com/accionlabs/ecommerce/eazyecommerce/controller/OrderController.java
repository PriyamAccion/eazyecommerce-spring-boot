package com.accionlabs.ecommerce.eazyecommerce.controller;

import com.accionlabs.ecommerce.eazyecommerce.dto.OrderDto;
import com.accionlabs.ecommerce.eazyecommerce.entities.Order;
import com.accionlabs.ecommerce.eazyecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place/{userId}")
    public ResponseEntity<OrderDto> placeOrder(@PathVariable Long userId) {
        OrderDto completedOrder = orderService.placeOrder(userId);
        return ResponseEntity.ok(completedOrder);
    }
}
