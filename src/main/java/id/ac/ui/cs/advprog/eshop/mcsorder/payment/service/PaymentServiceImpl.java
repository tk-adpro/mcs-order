package id.ac.ui.cs.advprog.eshop.mcsorder.payment.service;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.domain.PaymentService;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.exception.PaymentNotFoundException;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.factory.PaymentFactory;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.repository.PaymentRepository;
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

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public Payment createPayment(Payment payment) {
        Payment createdPayment = paymentRepository.save(payment);
        messagingTemplate.convertAndSend("/topic/payments", "Payment created: " + createdPayment.getId());
        return createdPayment;
    }

    @Override
    @Async
    public CompletableFuture<Payment> processPaymentAsync(Long orderId, double amount, String status) {
        return CompletableFuture.supplyAsync(() -> {
            Payment payment = PaymentFactory.createPayment(orderId, amount, status);
            Payment createdPayment = paymentRepository.save(payment);
            messagingTemplate.convertAndSend("/topic/payments", "Payment processed: " + createdPayment.getId());
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
        messagingTemplate.convertAndSend("/topic/payments", "Payment deleted: " + id);
    }
}
