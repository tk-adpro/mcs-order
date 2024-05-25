// PaymentNotificationServiceTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import static org.mockito.Mockito.*;

class PaymentNotificationServiceTest {

    @Mock
    private SimpMessagingTemplate messagingTemplate;

    @InjectMocks
    private PaymentNotificationService paymentNotificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdate() {
        String message = "Payment status updated";

        paymentNotificationService.update(message);

        verify(messagingTemplate, times(1)).convertAndSend("/topic/payments", message);
    }
}