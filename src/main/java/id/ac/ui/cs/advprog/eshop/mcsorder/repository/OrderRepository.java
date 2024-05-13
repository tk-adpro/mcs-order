package id.ac.ui.cs.advprog.eshop.mcsorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.ui.cs.advprog.eshop.mcsorder.model.Order;

// OrderRepository.java
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
