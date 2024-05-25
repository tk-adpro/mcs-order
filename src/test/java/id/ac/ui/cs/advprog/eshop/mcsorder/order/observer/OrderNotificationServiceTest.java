// OrderNotificationServiceTest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.order.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import static org.mockito.Mockito.*;

class OrderNotificationServiceTest {

    @Mock
    private SimpMessagingTemplate messagingTemplate;

    @InjectMocks
    private OrderNotificationService orderNotificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdate() {
        String message = "Order status updated";

        orderNotificationService.update(message);

        verify(messagingTemplate, times(1)).convertAndSend("/topic/orders", message);
    }
}
