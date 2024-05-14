// PaymentServiceImpl.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.service;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.domain.PaymentService;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.exception.PaymentNotFoundException;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.factory.PaymentFactory;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer.PaymentNotificationService;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer.PaymentSubject;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.repository.PaymentRepository;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    private final PaymentSubject paymentSubject;

    public PaymentServiceImpl(SimpMessagingTemplate messagingTemplate) {
        this.paymentSubject = new PaymentSubject();
        paymentSubject.addObserver(new PaymentNotificationService(messagingTemplate));
    }

    @Override
    public Payment createPayment(Payment payment) {
        Payment createdPayment = paymentRepository.save(payment);
        paymentSubject.notifyObservers("Payment created: " + createdPayment.getId());
        return createdPayment;
    }

    @Override
    @Async
    public CompletableFuture<Payment> processPaymentAsync(Long orderId, double amount, String paymentMethod) {
        return CompletableFuture.supplyAsync(() -> {
            PaymentContext context = new PaymentContext();

            switch (paymentMethod) {
                case "CREDIT_CARD":
                    context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "John Doe", "12/23"));
                    break;
                case "DEBIT_CARD":
                    context.setPaymentStrategy(new DebitCardPayment("4321-8765-6789-2345", "Jane Doe", "11/24"));
                    break;
                case "GOPAY":
                    context.setPaymentStrategy(new GopayPayment("GOPAY-12345"));
                    break;
                case "PAYPAL":
                    context.setPaymentStrategy(new PayPalPayment("john.doe@example.com", "password"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
            }

            context.pay(amount);

            Payment payment = PaymentFactory.createPayment(orderId, amount, paymentMethod);
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
