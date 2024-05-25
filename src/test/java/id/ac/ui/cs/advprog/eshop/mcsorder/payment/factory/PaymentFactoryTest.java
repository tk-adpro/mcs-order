// PaymentFactoryTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.factory;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void testCreatePayment() {
        Long orderId = 123L;
        double amount = 100.50;
        String status = "PENDING";
        String validationStatus = "PENDING";

        Payment payment = PaymentFactory.createPayment(orderId, amount, status, validationStatus);

        assertEquals(orderId, payment.getOrderId());
        assertEquals(amount, payment.getAmount());
        assertEquals(status, payment.getStatus());
        assertEquals(validationStatus, payment.getValidationStatus());
        assertNotNull(payment.getPaymentDate());
        assertTrue(payment.getPaymentDate().isBefore(LocalDateTime.now().plusSeconds(1)));
        assertTrue(payment.getPaymentDate().isAfter(LocalDateTime.now().minusSeconds(1)));
    }
}
