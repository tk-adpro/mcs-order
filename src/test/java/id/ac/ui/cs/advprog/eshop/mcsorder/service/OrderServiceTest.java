// OrderServiceTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.service;

import id.ac.ui.cs.advprog.eshop.mcsorder.exception.OrderNotFoundException;
import id.ac.ui.cs.advprog.eshop.mcsorder.model.Order;
import id.ac.ui.cs.advprog.eshop.mcsorder.repository.OrderRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        
        Order createdOrder = orderService.createOrder(order);
        
        assertNotNull(createdOrder);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void testGetOrderById() {
        Order order = new Order();
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));
        
        Order foundOrder = orderService.getOrderById(1L);
        
        assertNotNull(foundOrder);
        verify(orderRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetOrderByIdNotFound() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.empty());
        
        assertThrows(OrderNotFoundException.class, () -> {
            orderService.getOrderById(1L);
        });
    }

    @Test
    public void testDeleteOrder() {
        doNothing().when(orderRepository).deleteById(anyLong());
        
        orderService.deleteOrder(1L);
        
        verify(orderRepository, times(1)).deleteById(1L);
    }
}