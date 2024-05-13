// OrderRepositoryTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.repository;

import id.ac.ui.cs.advprog.eshop.mcsorder.model.Order;
import id.ac.ui.cs.advprog.eshop.mcsorder.model.OrderItem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testSaveOrder() {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerName("John Doe");
        
        OrderItem item = new OrderItem();
        item.setProductName("Sample Product");
        item.setPrice(19.99);
        item.setQuantity(2);
        item.setOrder(order); // set the relation
        
        order.setItems(Collections.singletonList(item));

        Order savedOrder = orderRepository.save(order);

        assertNotNull(savedOrder.getId());
        assertFalse(savedOrder.getItems().isEmpty());
        assertEquals("John Doe", savedOrder.getCustomerName());
    }

    @Test
    public void testFindAllOrders() {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerName("Alice Smith");

        OrderItem item = new OrderItem();
        item.setProductName("Another Product");
        item.setPrice(29.99);
        item.setQuantity(1);
        item.setOrder(order);
        
        order.setItems(Collections.singletonList(item));

        orderRepository.save(order);

        Iterable<Order> orders = orderRepository.findAll();
        assertTrue(orders.iterator().hasNext()); 
    }

    @Test
    public void testFindOrderById() {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerName("Bob Johnson");

        OrderItem item = new OrderItem();
        item.setProductName("New Product");
        item.setPrice(49.99);
        item.setQuantity(3);
        item.setOrder(order);
        
        order.setItems(Collections.singletonList(item));

        Order savedOrder = orderRepository.save(order);
        
        Order foundOrder = orderRepository.findById(savedOrder.getId()).orElse(null);
        assertNotNull(foundOrder);
        assertEquals("Bob Johnson", foundOrder.getCustomerName());
    }

    @Test
    public void testDeleteOrder() {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerName("Charlie Davis");

        OrderItem item = new OrderItem();
        item.setProductName("Old Product");
        item.setPrice(15.99);
        item.setQuantity(4);
        item.setOrder(order);
        
        order.setItems(Collections.singletonList(item));

        Order savedOrder = orderRepository.save(order);

        assertNotNull(orderRepository.findById(savedOrder.getId()));

        orderRepository.deleteById(savedOrder.getId());

        assertFalse(orderRepository.findById(savedOrder.getId()).isPresent());
    }
}