// OrderRepository.java
package id.ac.ui.cs.advprog.eshop.mcsorder.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.Order;

// OrderRepository.java
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
