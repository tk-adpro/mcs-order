// OrderNotificationService.java

package id.ac.ui.cs.advprog.eshop.mcsorder.order.observer;

import org.springframework.stereotype.Service;

@Service
public class OrderNotificationService implements OrderObserver {

    @Override
    public void update(String message) {
        System.out.println("Notification received: " + message);
    }
}

