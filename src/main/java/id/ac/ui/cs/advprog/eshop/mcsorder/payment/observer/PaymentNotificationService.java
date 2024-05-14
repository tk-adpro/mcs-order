// PaymentNotificationService.java

package id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentNotificationService implements PaymentObserver {
    private final SimpMessagingTemplate messagingTemplate;

    public PaymentNotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void update(String message) {
        messagingTemplate.convertAndSend("/topic/payments", message);
    }
}
