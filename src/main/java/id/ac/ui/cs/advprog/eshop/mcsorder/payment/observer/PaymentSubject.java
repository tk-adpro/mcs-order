// PaymentSubject.java

package id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer;

import java.util.ArrayList;
import java.util.List;

public class PaymentSubject {
    private List<PaymentObserver> observers = new ArrayList<>();

    public void addObserver(PaymentObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PaymentObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (PaymentObserver observer : observers) {
            observer.update(message);
        }
    }
}