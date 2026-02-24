package com.accionlabs.ecommerce.eazyecommerce.service;

import com.accionlabs.ecommerce.eazyecommerce.dto.CartRequestDto;
import com.accionlabs.ecommerce.eazyecommerce.dto.CartResponseDto;

import java.util.List;

public interface CartService {

     CartResponseDto addToCart(CartRequestDto cartDto);
     List<CartResponseDto> getCartItems(Long userId);
    void removeFromCart(Long userId, Long productId);
}
