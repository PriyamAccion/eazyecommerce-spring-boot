package com.accionlabs.ecommerce.eazyecommerce.service.impl;

import com.accionlabs.ecommerce.eazyecommerce.entities.Cart;
import com.accionlabs.ecommerce.eazyecommerce.entities.Order;
import com.accionlabs.ecommerce.eazyecommerce.entities.OrderItem;
import com.accionlabs.ecommerce.eazyecommerce.entities.User;
import com.accionlabs.ecommerce.eazyecommerce.repository.CartRepository;
import com.accionlabs.ecommerce.eazyecommerce.repository.OrderItemRepository;
import com.accionlabs.ecommerce.eazyecommerce.repository.OrderRepository;
import com.accionlabs.ecommerce.eazyecommerce.repository.UserRepository;
import com.accionlabs.ecommerce.eazyecommerce.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(UserRepository userRepository, CartRepository cartRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Transactional
    public Order placeOrder(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<Cart> cartItems = cartRepository.findByUserId(userId);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty. Cannot place an order.");
        }

        double total = 0.0;

        for (Cart item : cartItems) {
            total += (item.getProduct().getPrice() * item.getQuantity());
        }
        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(total);
        order.setOrderDate(LocalDateTime.now());
        Order savedOrder = orderRepository.save(order);

        for (Cart cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getProduct().getPrice());
            orderItemRepository.save(orderItem);
        }
        cartRepository.deleteAll(cartItems);
        return savedOrder;
    }
}