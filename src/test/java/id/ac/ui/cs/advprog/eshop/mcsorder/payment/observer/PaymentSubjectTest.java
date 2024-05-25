// PaymentSubjectTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class PaymentSubjectTest {

    private PaymentSubject paymentSubject;
    private PaymentObserver observer1;
    private PaymentObserver observer2;

    @BeforeEach
    void setUp() {
        paymentSubject = new PaymentSubject();
        observer1 = Mockito.mock(PaymentObserver.class);
        observer2 = Mockito.mock(PaymentObserver.class);
    }

    @Test
    void testAddObserver() {
        paymentSubject.addObserver(observer1);
        paymentSubject.notifyObservers("Test Message");

        verify(observer1, times(1)).update("Test Message");
    }

    @Test
    void testRemoveObserver() {
        paymentSubject.addObserver(observer1);
        paymentSubject.removeObserver(observer1);
        paymentSubject.notifyObservers("Test Message");

        verify(observer1, times(0)).update("Test Message");
    }

    @Test
    void testNotifyObservers() {
        paymentSubject.addObserver(observer1);
        paymentSubject.addObserver(observer2);
        paymentSubject.notifyObservers("Test Message");

        verify(observer1, times(1)).update("Test Message");
        verify(observer2, times(1)).update("Test Message");
    }
}
