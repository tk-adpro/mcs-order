// OrderRepository.java
package id.ac.ui.cs.advprog.eshop.mcsorder.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
