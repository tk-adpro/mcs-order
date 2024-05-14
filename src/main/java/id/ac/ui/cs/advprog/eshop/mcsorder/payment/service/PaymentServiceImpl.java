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
    public CompletableFuture<Payment> processPaymentAsync(
        Long orderId,
        double amount, 
        String paymentMethod, 
        String paymentDetails
        ) {

        return CompletableFuture.supplyAsync(() -> {
            PaymentContext context = new PaymentContext();

            switch (paymentMethod) {
                case "CREDIT_CARD":
                    String[] ccDetails = paymentDetails.split(",");
                    context.setPaymentStrategy(new CreditCardPayment(ccDetails[0], ccDetails[1], ccDetails[2]));
                    break;
                case "DEBIT_CARD":
                    String[] dcDetails = paymentDetails.split(",");
                    context.setPaymentStrategy(new DebitCardPayment(dcDetails[0], dcDetails[1], dcDetails[2]));
                    break;
                case "GOPAY":
                    context.setPaymentStrategy(new GopayPayment(paymentDetails));
                    break;
                case "PAYPAL":
                    String[] ppDetails = paymentDetails.split(",");
                    context.setPaymentStrategy(new PayPalPayment(ppDetails[0], ppDetails[1]));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
            }

            context.pay(amount);

            Payment payment = PaymentFactory.createPayment(orderId, amount, paymentMethod, "PENDING");
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
