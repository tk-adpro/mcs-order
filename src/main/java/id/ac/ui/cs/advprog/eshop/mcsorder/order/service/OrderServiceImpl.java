// OrderServiceImpl.java
package id.ac.ui.cs.advprog.eshop.mcsorder.order.service;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.domain.OrderService;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.exception.OrderNotFoundException;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.factory.OrderFactory;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.Order;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.OrderItem;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.observer.OrderNotificationService;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.observer.OrderSubject;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.dto.PaymentRequest;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;
import id.ac.ui.cs.advprog.eshop.mcsorder.payment.domain.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentService paymentService;

    private final OrderSubject orderSubject;

    @Autowired
    public OrderServiceImpl() {
        this.orderSubject = new OrderSubject();
        this.orderSubject.addObserver(new OrderNotificationService());
    }

    @Override
    public Order createOrder(Order order) {
        Order createdOrder = orderRepository.save(order);
        orderSubject.notifyObservers("Order created: " + createdOrder.getId());
        return createdOrder;
    }

    @Override
    @Async
    public CompletableFuture<Order> createOrderAsync(String customerName, List<OrderItem> items) {
        return CompletableFuture.supplyAsync(() -> {
            Order order = OrderFactory.createOrder(customerName, items);
            Order createdOrder = orderRepository.save(order);
            orderSubject.notifyObservers("Order created: " + createdOrder.getId());
            return createdOrder;
        });
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
        orderSubject.notifyObservers("Order deleted: " + id);
    }

    public CompletableFuture<Payment> processPaymentForOrder(Long orderId, PaymentRequest paymentRequest) {
        return paymentService.processPaymentAsync(
                paymentRequest.getOrderId(),
                paymentRequest.getAmount(),
                paymentRequest.getPaymentMethod(),
                paymentRequest.getPaymentDetails()
        );
    }
}
