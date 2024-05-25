package id.ac.ui.cs.advprog.eshop.mcsorder.order.factory;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.Order;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.OrderItem;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void testCreateOrder() {
        String customerName = "John Doe";
        List<OrderItem> items = new ArrayList<>();

        OrderItem item1 = new OrderItem();
        item1.setProductName("Product 1");
        item1.setQuantity(2);
        item1.setPrice(100.0);
        items.add(item1);

        OrderItem item2 = new OrderItem();
        item2.setProductName("Product 2");
        item2.setQuantity(1);
        item2.setPrice(50.0);
        items.add(item2);

        Order order = OrderFactory.createOrder(customerName, items);

        assertEquals(customerName, order.getCustomerName());
        assertEquals(items, order.getItems());
        assertNotNull(order.getOrderDate());
        assertTrue(order.getOrderDate().isBefore(LocalDateTime.now().plusSeconds(1)));
        assertTrue(order.getOrderDate().isAfter(LocalDateTime.now().minusSeconds(1)));
    }
}