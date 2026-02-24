package com.accionlabs.ecommerce.eazyecommerce.controller;

import com.accionlabs.ecommerce.eazyecommerce.dto.OrderRequestDto;
import com.accionlabs.ecommerce.eazyecommerce.dto.OrderResponseDto;
import com.accionlabs.ecommerce.eazyecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
        OrderResponseDto completedOrder = orderService.placeOrder(orderRequestDto);
        return ResponseEntity.ok(completedOrder);
    }
}
