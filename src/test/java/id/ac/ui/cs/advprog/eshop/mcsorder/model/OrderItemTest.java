// OrderItemTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.model;

import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.Order;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.OrderItem;

import static org.junit.jupiter.api.Assertions.*;

public class OrderItemTest {

    @Test
    public void testOrderItemProperties() {
        OrderItem item = new OrderItem();

        item.setId(1L);
        item.setProductName("Product 1");
        item.setQuantity(2);
        item.setPrice(19.99);

        assertEquals(1L, item.getId());
        assertEquals("Product 1", item.getProductName());
        assertEquals(2, item.getQuantity());
        assertEquals(19.99, item.getPrice());
    }

    @Test
    public void testOrderItemOrderRelationship() {
        Order order = new Order();
        OrderItem item = new OrderItem();
        
        item.setOrder(order);
        order.getItems().add(item);

        assertEquals(order, item.getOrder());
        assertTrue(order.getItems().contains(item));
    }

    @Test
    public void testOrderItemDefaultOrder() {
        OrderItem item = new OrderItem();
        assertNull(item.getOrder());
    }
}
