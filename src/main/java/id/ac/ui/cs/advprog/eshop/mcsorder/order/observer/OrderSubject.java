// OrderSubject.java
package id.ac.ui.cs.advprog.eshop.mcsorder.order.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderSubject {
    private List<OrderObserver> observers = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (OrderObserver observer : observers) {
            observer.update(message);
        }
    }
}