// Order.java
package id.ac.ui.cs.advprog.eshop.mcsorder.order.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter; 
import lombok.Setter;
import id.ac.ui.cs.advprog.eshop.mcsorder.observer.OrderStatusObserver;

@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long customerId;
    private Double total;
    private LocalDateTime orderDate;
    private String customerName;
    private String status = "PENDING";
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    @Transient
    private List<OrderStatusObserver> observers = new ArrayList<>();

    public void addObserver(OrderStatusObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderStatusObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String status) {
        for (OrderStatusObserver observer : observers) {
            observer.update(status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers(status);
    }
}
