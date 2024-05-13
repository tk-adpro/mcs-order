// PaymentController.java
package id.ac.ui.cs.advprog.eshop.mcsorder.controller;

import id.ac.ui.cs.advprog.eshop.mcsorder.dto.PaymentRequest;
import id.ac.ui.cs.advprog.eshop.mcsorder.model.Payment;
import id.ac.ui.cs.advprog.eshop.mcsorder.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public CompletableFuture<ResponseEntity<Payment>> createPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.processPaymentAsync(paymentRequest.getOrderId(), paymentRequest.getAmount(), paymentRequest.getStatus())
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}