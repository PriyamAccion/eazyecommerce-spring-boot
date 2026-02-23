package com.accionlabs.ecommerce.eazyecommerce.repository;

import com.accionlabs.ecommerce.eazyecommerce.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
