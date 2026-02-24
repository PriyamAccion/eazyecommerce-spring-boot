package com.accionlabs.ecommerce.eazyecommerce.service;

import com.accionlabs.ecommerce.eazyecommerce.dto.CartDto;
import java.util.List;

public interface CartService {

     CartDto addToCart(CartDto cartDto);
     List<CartDto> getCartItems(Long userId);
    void removeFromCart(Long userId, Long productId);
}
