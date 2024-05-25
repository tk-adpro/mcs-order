// PaymentNotificationService.java

package id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer;

import org.springframework.stereotype.Service;

@Service
public class PaymentNotificationService implements PaymentObserver {
    @Override
    public void update(String message) {
        System.out.println("Notification received: " + message);
    }
}
