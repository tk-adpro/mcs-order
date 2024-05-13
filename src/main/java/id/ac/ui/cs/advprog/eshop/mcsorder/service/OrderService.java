package id.ac.ui.cs.advprog.eshop.mcsorder.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.mcsorder.exception.OrderNotFoundException;
import id.ac.ui.cs.advprog.eshop.mcsorder.factory.OrderFactory;
import id.ac.ui.cs.advprog.eshop.mcsorder.model.Order;
import id.ac.ui.cs.advprog.eshop.mcsorder.model.OrderItem;
import id.ac.ui.cs.advprog.eshop.mcsorder.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Async
    public CompletableFuture<Order> createOrderAsync(String customerName, List<OrderItem> items) {
        return CompletableFuture.supplyAsync(() -> {
            Order order = OrderFactory.createOrder(customerName, items);
            return orderRepository.save(order);
        });
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}