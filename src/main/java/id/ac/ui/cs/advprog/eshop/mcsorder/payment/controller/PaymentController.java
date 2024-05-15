// PaymentController.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.controller;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.domain.PaymentService;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.dto.PaymentRequest;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;

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
        return paymentService.processPaymentAsync(
            paymentRequest.getOrderId(), 
            paymentRequest.getAmount(), 
            paymentRequest.getPaymentMethod(),
            paymentRequest.getPaymentDetails()
            )
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok().build();
    }
}
