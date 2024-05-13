// OrderRepositoryTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.repository;

import id.ac.ui.cs.advprog.eshop.mcsorder.model.Order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testSaveOrder() {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerName("John Doe");

        Order savedOrder = orderRepository.save(order);

        assertNotNull(savedOrder.getId());
    }

    @Test
    public void testFindAllOrders() {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerName("Alice Smith");

        orderRepository.save(order);

        List<Order> orders = orderRepository.findAll();
        assertFalse(orders.isEmpty());
    }

    @Test
    public void testFindOrderById() {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerName("Bob Johnson");

        Order savedOrder = orderRepository.save(order);

        Order foundOrder = orderRepository.findById(savedOrder.getId()).orElse(null);
        assertNotNull(foundOrder);
    }

    @Test
    public void testDeleteOrder() {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerName("Charlie Davis");

        Order savedOrder = orderRepository.save(order);

        assertNotNull(orderRepository.findById(savedOrder.getId()));

        orderRepository.deleteById(savedOrder.getId());

        assertFalse(orderRepository.findById(savedOrder.getId()).isPresent());
    }
}
