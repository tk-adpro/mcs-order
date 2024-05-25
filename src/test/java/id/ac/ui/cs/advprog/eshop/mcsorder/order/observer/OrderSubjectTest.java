// OrderSubjectTest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.order.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class OrderSubjectTest {

    private OrderSubject orderSubject;
    private OrderObserver observer1;
    private OrderObserver observer2;

    @BeforeEach
    void setUp() {
        orderSubject = new OrderSubject();
        observer1 = Mockito.mock(OrderObserver.class);
        observer2 = Mockito.mock(OrderObserver.class);
    }

    @Test
    void testAddObserver() {
        orderSubject.addObserver(observer1);
        orderSubject.notifyObservers("Test Message");

        verify(observer1, times(1)).update("Test Message");
    }

    @Test
    void testRemoveObserver() {
        orderSubject.addObserver(observer1);
        orderSubject.removeObserver(observer1);
        orderSubject.notifyObservers("Test Message");

        verify(observer1, times(0)).update("Test Message");
    }

    @Test
    void testNotifyObservers() {
        orderSubject.addObserver(observer1);
        orderSubject.addObserver(observer2);
        orderSubject.notifyObservers("Test Message");

        verify(observer1, times(1)).update("Test Message");
        verify(observer2, times(1)).update("Test Message");
    }
}