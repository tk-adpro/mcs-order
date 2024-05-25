package id.ac.ui.cs.advprog.eshop.mcsorder.order.dto;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.OrderItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRequestTest {

    @Test
    void testCustomerName() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setCustomerName("John Doe");

        assertEquals("John Doe", orderRequest.getCustomerName());
    }

    @Test
    void testItems() {
        OrderRequest orderRequest = new OrderRequest();
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
        
        orderRequest.setItems(items);

        assertEquals(2, orderRequest.getItems().size());
        assertEquals("Product 1", orderRequest.getItems().get(0).getProductName());
        assertEquals(2, orderRequest.getItems().get(0).getQuantity());
        assertEquals(100.0, orderRequest.getItems().get(0).getPrice());
        assertEquals("Product 2", orderRequest.getItems().get(1).getProductName());
        assertEquals(1, orderRequest.getItems().get(1).getQuantity());
        assertEquals(50.0, orderRequest.getItems().get(1).getPrice());
    }
}