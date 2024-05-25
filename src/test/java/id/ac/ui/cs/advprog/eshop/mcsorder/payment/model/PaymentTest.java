// PaymentTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    public void testPaymentProperties() {
        Payment payment = new Payment();
        LocalDateTime now = LocalDateTime.now();

        payment.setId(1L);
        payment.setOrderId(101L);
        payment.setAmount(150.75);
        payment.setPaymentDate(now);
        payment.setStatus("PAID");

        assertEquals(1L, payment.getId());
        assertEquals(101L, payment.getOrderId());
        assertEquals(150.75, payment.getAmount());
        assertEquals(now, payment.getPaymentDate());
        assertEquals("PAID", payment.getStatus());
    }

    @Test
    public void testDefaultPaymentProperties() {
        Payment payment = new Payment();

        assertNull(payment.getId());
        assertNull(payment.getOrderId());
        assertEquals(0.0, payment.getAmount());
        assertNull(payment.getPaymentDate());
        assertNull(payment.getStatus());
    }
}