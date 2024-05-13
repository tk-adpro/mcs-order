// PaymentService.java
package id.ac.ui.cs.advprog.eshop.mcsorder.service;

import id.ac.ui.cs.advprog.eshop.mcsorder.exception.PaymentNotFoundException;
import id.ac.ui.cs.advprog.eshop.mcsorder.factory.PaymentFactory;
import id.ac.ui.cs.advprog.eshop.mcsorder.model.Payment;
import id.ac.ui.cs.advprog.eshop.mcsorder.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Async
    public CompletableFuture<Payment> processPaymentAsync(Long orderId, double amount, String status) {
        return CompletableFuture.supplyAsync(() -> {
            Payment payment = PaymentFactory.createPayment(orderId, amount, status);
            return paymentRepository.save(payment);
        });
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
