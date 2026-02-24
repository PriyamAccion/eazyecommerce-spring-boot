package com.accionlabs.ecommerce.eazyecommerce.mapper;

import com.accionlabs.ecommerce.eazyecommerce.dto.CartDto;
import com.accionlabs.ecommerce.eazyecommerce.entities.Cart;

public final class CartMapper {

    private CartMapper() {
    }

    public static CartDto toDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setUserId(cart.getUser().getId());
        cartDto.setProductId(cart.getProduct().getId());
        cartDto.setQuantity(cart.getQuantity());
        return cartDto;
    }
}
