// PaymentContextTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PaymentContextTest {

    private PaymentContext paymentContext;
    private PaymentStrategy paymentStrategy;

    @BeforeEach
    void setUp() {
        paymentContext = new PaymentContext();
        paymentStrategy = mock(PaymentStrategy.class);
        paymentContext.setPaymentStrategy(paymentStrategy);
    }

    @Test
    void testPay() {
        double amount = 300.0;

        paymentContext.pay(amount);

        verify(paymentStrategy, times(1)).pay(amount);
    }
}
