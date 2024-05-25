// PaymentNotFoundExceptionTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentNotFoundExceptionTest {

    @Test
    void testPaymentNotFoundException() {
        Long paymentId = 123L;
        PaymentNotFoundException exception = new PaymentNotFoundException(paymentId);

        assertEquals("Payment with ID " + paymentId + " not found.", exception.getMessage());
    }
}
