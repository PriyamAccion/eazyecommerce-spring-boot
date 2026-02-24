package com.accionlabs.ecommerce.eazyecommerce.service.impl;

import com.accionlabs.ecommerce.eazyecommerce.dto.CartDto;
import com.accionlabs.ecommerce.eazyecommerce.entities.Cart;
import com.accionlabs.ecommerce.eazyecommerce.entities.Product;
import com.accionlabs.ecommerce.eazyecommerce.entities.User;
import com.accionlabs.ecommerce.eazyecommerce.mapper.CartMapper;
import com.accionlabs.ecommerce.eazyecommerce.repository.CartRepository;
import com.accionlabs.ecommerce.eazyecommerce.repository.ProductRepository;
import com.accionlabs.ecommerce.eazyecommerce.repository.UserRepository;
import com.accionlabs.ecommerce.eazyecommerce.service.CartService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartDto addToCart(CartDto cartDto)
    {
        Integer quantity = cartDto.getQuantity();
        Long userId = cartDto.getUserId();
        Long productId = cartDto.getProductId();
        if (quantity == null || quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        if (product.getStockQuantity() <= 0) {
            throw new RuntimeException("Product is currently out of stock");
        }
        Cart cart = cartRepository.findByUserIdAndProductId(userId, productId).orElse(null);
        if (cart != null) {
            int newQuantity = cart.getQuantity() + quantity;
            if (newQuantity > product.getStockQuantity()) {
                throw new RuntimeException("Cannot add more items. Available stock: " + product.getStockQuantity());
            }
            cart.setQuantity(newQuantity);

        } else {
            if (quantity > product.getStockQuantity()) {
                throw new RuntimeException("Insufficient stock. Available: " + product.getStockQuantity());
            }
            cart = new Cart();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setQuantity(quantity);
        }
        return CartMapper.toDto(cartRepository.save(cart));
    }

    @Override
    public List<CartDto> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId).stream().map(CartMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void removeFromCart(Long userId, Long productId) {
        Cart cart = cartRepository.findByUserIdAndProductId(userId, productId).orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartRepository.delete(cart);
    }


}
