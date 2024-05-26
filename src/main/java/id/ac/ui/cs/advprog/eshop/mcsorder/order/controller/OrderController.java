// OrderController.java
package id.ac.ui.cs.advprog.eshop.mcsorder.order.controller;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.domain.OrderService;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.dto.OrderRequest;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.Order;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.dto.PaymentRequest;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public CompletableFuture<ResponseEntity<Order>> createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrderAsync(orderRequest.getCustomerName(), orderRequest.getItems())
                .thenApply(ResponseEntity::ok);
    }

    @PostMapping("/{orderId}/payment")
    public CompletableFuture<ResponseEntity<Payment>> processPaymentForOrder(
            @PathVariable Long orderId,
            @Valid @RequestBody PaymentRequest paymentRequest
    ) {
        return orderService.processPaymentForOrder(orderId, paymentRequest)
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
