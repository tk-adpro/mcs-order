// PaymentService.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.domain;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PaymentService {
    Payment createPayment(Payment payment);
    CompletableFuture<Payment> processPaymentAsync(Long orderId, double amount, String paymentMethod, String paymentDetails);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
    void deletePayment(Long id);
}
