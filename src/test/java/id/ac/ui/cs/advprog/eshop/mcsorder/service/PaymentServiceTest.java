// PaymentServiceTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.service;

import id.ac.ui.cs.advprog.eshop.mcsorder.exception.PaymentNotFoundException;
import id.ac.ui.cs.advprog.eshop.mcsorder.model.Payment;
import id.ac.ui.cs.advprog.eshop.mcsorder.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePayment() {
        Payment payment = new Payment();
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
        
        Payment createdPayment = paymentService.createPayment(payment);
        
        assertNotNull(createdPayment);
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    public void testGetPaymentById() {
        Payment payment = new Payment();
        when(paymentRepository.findById(anyLong())).thenReturn(Optional.of(payment));
        
        Payment foundPayment = paymentService.getPaymentById(1L);
        
        assertNotNull(foundPayment);
        verify(paymentRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetPaymentByIdNotFound() {
        when(paymentRepository.findById(anyLong())).thenReturn(Optional.empty());
        
        assertThrows(PaymentNotFoundException.class, () -> {
            paymentService.getPaymentById(1L);
        });
    }

    @Test
    public void testDeletePayment() {
        doNothing().when(paymentRepository).deleteById(anyLong());
        
        paymentService.deletePayment(1L);
        
        verify(paymentRepository, times(1)).deleteById(1L);
    }
}
