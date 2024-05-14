// OrderNotificationService.java

package id.ac.ui.cs.advprog.eshop.mcsorder.order.observer;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderNotificationService implements OrderObserver {
    private final SimpMessagingTemplate messagingTemplate;

    public OrderNotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void update(String message) {
        messagingTemplate.convertAndSend("/topic/orders", message);
    }
}
