// OrderServiceImpl.java
package id.ac.ui.cs.advprog.eshop.mcsorder.order.service;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.domain.OrderService;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.exception.OrderNotFoundException;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.factory.OrderFactory;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.Order;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.OrderItem;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public Order createOrder(Order order) {
        Order createdOrder = orderRepository.save(order);
        messagingTemplate.convertAndSend("/topic/orders", "Order created: " + createdOrder.getId());
        return createdOrder;
    }

    @Override
    @Async
    public CompletableFuture<Order> createOrderAsync(String customerName, List<OrderItem> items) {
        return CompletableFuture.supplyAsync(() -> {
            Order order = OrderFactory.createOrder(customerName, items);
            Order createdOrder = orderRepository.save(order);
            messagingTemplate.convertAndSend("/topic/orders", "Order created: " + createdOrder.getId());
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
        orderRepository.deleteById(id);
        messagingTemplate.convertAndSend("/topic/orders", "Order deleted: " + id);
    }
}
