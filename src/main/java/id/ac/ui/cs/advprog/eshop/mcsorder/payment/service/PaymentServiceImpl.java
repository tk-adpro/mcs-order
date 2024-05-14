// PaymentServiceImpl.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.service;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.domain.PaymentService;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.exception.PaymentNotFoundException;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.factory.PaymentFactory;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer.PaymentNotificationService;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer.PaymentSubject;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentNotificationService notificationService;

    private final PaymentSubject paymentSubject = new PaymentSubject();

    public PaymentServiceImpl(PaymentNotificationService notificationService) {
        this.notificationService = notificationService;
        paymentSubject.addObserver(notificationService);
    }

    @Override
    public Payment createPayment(Payment payment) {
        Payment createdPayment = paymentRepository.save(payment);
        paymentSubject.notifyObservers("Payment created: " + createdPayment.getId());
        return createdPayment;
    }

    @Override
    @Async
    public CompletableFuture<Payment> processPaymentAsync(Long orderId, double amount, String status) {
        return CompletableFuture.supplyAsync(() -> {
            Payment payment = PaymentFactory.createPayment(orderId, amount, status);
            Payment createdPayment = paymentRepository.save(payment);
            paymentSubject.notifyObservers("Payment processed: " + createdPayment.getId());
            return createdPayment;
        });
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
        paymentSubject.notifyObservers("Payment deleted: " + id);
    }
}
