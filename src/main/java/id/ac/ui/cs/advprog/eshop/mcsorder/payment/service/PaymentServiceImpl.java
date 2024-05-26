// PaymentServiceImpl.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.service;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.domain.PaymentService;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.exception.InvalidPaymentDetailsException;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.exception.PaymentNotFoundException;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.exception.PaymentProcessingException;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.factory.PaymentFactory;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer.PaymentNotificationService;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.observer.PaymentSubject;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.repository.PaymentRepository;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    private final PaymentSubject paymentSubject;

    @Autowired
    public PaymentServiceImpl() {
        this.paymentSubject = new PaymentSubject();
        this.paymentSubject.addObserver(new PaymentNotificationService());
    }

    @Override
    public Payment createPayment(Payment payment) {
        Payment createdPayment = paymentRepository.save(payment);
        paymentSubject.notifyObservers("Payment created: " + createdPayment.getId());
        return createdPayment;
    }

    private PaymentStrategy getPaymentStrategy(String paymentMethod, String paymentDetails) {
        switch (paymentMethod) {
            case "CREDIT_CARD":
                String[] ccDetails = paymentDetails.split(",");
                if (ccDetails.length != 3) {
                    throw new InvalidPaymentDetailsException("Invalid credit card details");
                }
                return new CreditCardPayment(ccDetails[0], ccDetails[1], ccDetails[2]);
            case "DEBIT_CARD":
                String[] dcDetails = paymentDetails.split(",");
                if (dcDetails.length != 3) {
                    throw new InvalidPaymentDetailsException("Invalid debit card details");
                }
                return new DebitCardPayment(dcDetails[0], dcDetails[1], dcDetails[2]);
            case "GOPAY":
                return new GopayPayment(paymentDetails);
            case "PAYPAL":
                String[] ppDetails = paymentDetails.split(",");
                if (ppDetails.length != 2) {
                    throw new InvalidPaymentDetailsException("Invalid PayPal details");
                }
                return new PayPalPayment(ppDetails[0], ppDetails[1]);
            default:
                throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
        }
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
            try {
                PaymentContext context = new PaymentContext();
                context.setPaymentStrategy(getPaymentStrategy(paymentMethod, paymentDetails));
                context.pay(amount);

                Payment payment = PaymentFactory.createPayment(orderId, amount, paymentMethod, "PENDING");
                Payment createdPayment = paymentRepository.save(payment);
                paymentSubject.notifyObservers("Payment processed: " + createdPayment.getId());
                return createdPayment;
            } catch (Exception e) {
                throw new PaymentProcessingException("Failed to process payment", e);
            }
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
