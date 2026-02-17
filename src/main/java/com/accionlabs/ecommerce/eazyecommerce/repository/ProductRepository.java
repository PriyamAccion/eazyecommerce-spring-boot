package com.accionlabs.ecommerce.eazyecommerce.repository;

import com.accionlabs.ecommerce.eazyecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // CRUD
}
