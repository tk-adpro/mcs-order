// OrderItemRepository.java
package id.ac.ui.cs.advprog.eshop.mcsorder.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.OrderItem;

// OrderItemRepository.java
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}