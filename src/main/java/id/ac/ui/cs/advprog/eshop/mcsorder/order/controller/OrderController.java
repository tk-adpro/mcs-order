// OrderController.java
package id.ac.ui.cs.advprog.eshop.mcsorder.order.controller;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.domain.OrderService;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.dto.OrderRequest;
import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
