package id.ac.ui.cs.advprog.eshop.mcsorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.ui.cs.advprog.eshop.mcsorder.model.OrderItem;

// OrderItemRepository.java
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}