// OrderService.java
package id.ac.ui.cs.advprog.eshop.mcsorder.order.domain;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.Order;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.OrderItem;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.dto.PaymentRequest;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;
import jakarta.validation.Valid;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface OrderService {
    
    Order createOrder(Order order);
    CompletableFuture<Order> createOrderAsync(String customerName, List<OrderItem> items);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    void deleteOrder(Long id);
    CompletableFuture<Payment> processPaymentForOrder(Long orderId, @Valid PaymentRequest paymentRequest);
}
