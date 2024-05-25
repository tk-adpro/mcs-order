package id.ac.ui.cs.advprog.eshop.mcsorder.order.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderNotFoundExceptionTest {

    @Test
    void testOrderNotFoundException() {
        Long orderId = 123L;
        OrderNotFoundException exception = new OrderNotFoundException(orderId);

        assertEquals("Order with ID " + orderId + " not found.", exception.getMessage());
    }
}