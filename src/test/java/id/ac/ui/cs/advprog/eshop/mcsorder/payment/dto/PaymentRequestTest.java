package id.ac.ui.cs.advprog.eshop.mcsorder.payment.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentRequestTest {

    @Test
    void testOrderId() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setOrderId(123L);

        assertEquals(123L, paymentRequest.getOrderId());
    }

    @Test
    void testAmount() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(100.50);

        assertEquals(100.50, paymentRequest.getAmount());
    }

    @Test
    void testStatus() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setStatus("PENDING");

        assertEquals("PENDING", paymentRequest.getStatus());
    }

    @Test
    void testPaymentMethod() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setPaymentMethod("CREDIT_CARD");

        assertEquals("CREDIT_CARD", paymentRequest.getPaymentMethod());
    }

    @Test
    void testPaymentDetails() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setPaymentDetails("Card Number: 1234-5678-9876-5432");

        assertEquals("Card Number: 1234-5678-9876-5432", paymentRequest.getPaymentDetails());
    }
}