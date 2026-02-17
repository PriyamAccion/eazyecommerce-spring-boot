package com.accionlabs.ecommerce.eazyecommerce.service;

import com.accionlabs.ecommerce.eazyecommerce.entities.Product;

import java.util.List;

public interface ProductService {

        Product addProduct(Product product);
        List<Product> getAllProducts();
        Product getProductById(Long id);
        Product updateProduct(Long id, Product product);
        boolean deleteProduct(Long id);

}
