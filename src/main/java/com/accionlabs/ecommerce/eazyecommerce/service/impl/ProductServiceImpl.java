package com.accionlabs.ecommerce.eazyecommerce.service.impl;

import com.accionlabs.ecommerce.eazyecommerce.entities.Product;
import com.accionlabs.ecommerce.eazyecommerce.repository.ProductRepository;
import com.accionlabs.ecommerce.eazyecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    //Create
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    //Read
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //Read by id
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(productDetails.getName());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setCategory(productDetails.getCategory());
            existingProduct.setStockQuantity(productDetails.getStockQuantity());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
