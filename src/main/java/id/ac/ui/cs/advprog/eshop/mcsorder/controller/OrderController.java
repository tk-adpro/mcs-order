// OrderController.java
package id.ac.ui.cs.advprog.eshop.mcsorder.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.advprog.eshop.mcsorder.model.Order;
import id.ac.ui.cs.advprog.eshop.mcsorder.service.OrderService;
import id.ac.ui.cs.advprog.eshop.mcsorder.dto.OrderRequest;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public CompletableFuture<ResponseEntity<Order>> createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrderAsync(
            orderRequest.getCustomerName(), 
            orderRequest.getItems())
            .thenApply(ResponseEntity::ok);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}

