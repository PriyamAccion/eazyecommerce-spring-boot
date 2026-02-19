package com.accionlabs.ecommerce.eazyecommerce.service;

import com.accionlabs.ecommerce.eazyecommerce.entities.Cart;
import java.util.List;

public interface CartService {

     Cart addToCart(Long userId, Long productId, Integer quantity);
     List<Cart> getCartItems(Long userId);
    void removeFromCart(Long userId, Long productId);
}
