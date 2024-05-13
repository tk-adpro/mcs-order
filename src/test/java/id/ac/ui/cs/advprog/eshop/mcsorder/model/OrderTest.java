package id.ac.ui.cs.advprog.eshop.mcsorder.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testOrderProperties() {
        Order order = new Order();
        LocalDateTime now = LocalDateTime.now();

        order.setId(1L);
        order.setOrderDate(now);
        order.setCustomerName("John Doe");

        assertEquals(1L, order.getId());
        assertEquals(now, order.getOrderDate());
        assertEquals("John Doe", order.getCustomerName());
    }

    @Test
    public void testOrderItemsRelationship() {
        Order order = new Order();
        OrderItem item1 = new OrderItem();
        OrderItem item2 = new OrderItem();

        item1.setProductName("Product 1");
        item1.setPrice(10.0);
        item1.setQuantity(2);
        item1.setOrder(order);

        item2.setProductName("Product 2");
        item2.setPrice(20.0);
        item2.setQuantity(1);
        item2.setOrder(order);

        List<OrderItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        order.setItems(items);

        assertEquals(2, order.getItems().size());
        assertEquals(order, order.getItems().get(0).getOrder());
        assertEquals(order, order.getItems().get(1).getOrder());
        assertEquals("Product 1", order.getItems().get(0).getProductName());
        assertEquals("Product 2", order.getItems().get(1).getProductName());
    }

    @Test
    public void testOrderDefaultItems() {
        Order order = new Order();
        assertNotNull(order.getItems());
        assertTrue(order.getItems().isEmpty());
    }
}