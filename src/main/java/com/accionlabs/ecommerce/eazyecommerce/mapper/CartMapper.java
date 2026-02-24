package com.accionlabs.ecommerce.eazyecommerce.mapper;

import com.accionlabs.ecommerce.eazyecommerce.dto.CartResponseDto;
import com.accionlabs.ecommerce.eazyecommerce.entities.Cart;
import com.accionlabs.ecommerce.eazyecommerce.entities.OrderStatus;

public final class CartMapper {

    private CartMapper() {
    }

    public static CartResponseDto toDto(Cart cart) {
        CartResponseDto cartResponseDto = new CartResponseDto();
        cartResponseDto.setId(cart.getId());
        cartResponseDto.setUserId(cart.getUser().getId());
        cartResponseDto.setProductId(cart.getProduct().getId());
        cartResponseDto.setQuantity(cart.getQuantity());
        cartResponseDto.setStatus(OrderStatus.PENDING);
        return cartResponseDto;
    }
}
