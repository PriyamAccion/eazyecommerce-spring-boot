package com.accionlabs.ecommerce.eazyecommerce.repository;

import com.accionlabs.ecommerce.eazyecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}