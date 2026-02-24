package com.accionlabs.ecommerce.eazyecommerce.controller;

import com.accionlabs.ecommerce.eazyecommerce.dto.CartRequestDto;
import com.accionlabs.ecommerce.eazyecommerce.dto.CartResponseDto;
import com.accionlabs.ecommerce.eazyecommerce.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<CartResponseDto> addToCart(@RequestBody CartRequestDto cartDto) {
        return ResponseEntity.ok(cartService.addToCart(cartDto));
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartResponseDto>> getCartItems(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCartItems(userId));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFromCart(@RequestBody Map<String, Long> payload) {
        Long userId = payload.get("userId");
        Long productId = payload.get("productId");
        cartService.removeFromCart(userId, productId);
        return ResponseEntity.ok("Item removed from cart");
    }
}
