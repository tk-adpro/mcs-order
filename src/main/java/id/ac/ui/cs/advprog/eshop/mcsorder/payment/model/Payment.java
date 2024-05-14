// Payment.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long orderId;
    private double amount;
    private LocalDateTime paymentDate;
    private String status;
    private String paymentMethod;
    private String validationStatus = "PENDING";
    
}