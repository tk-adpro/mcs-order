// PaymentRepositoryTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.repository;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void testSavePayment() {
        Payment payment = new Payment();
        payment.setOrderId(1L);
        payment.setAmount(100.0);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("PAID");

        Payment savedPayment = paymentRepository.save(payment);

        assertNotNull(savedPayment.getId());
    }

    @Test
    public void testFindAllPayments() {
        Payment payment = new Payment();
        payment.setOrderId(1L);
        payment.setAmount(200.0);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("PAID");

        paymentRepository.save(payment);

        List<Payment> payments = paymentRepository.findAll();
        assertFalse(payments.isEmpty());
    }

    @Test
    public void testFindPaymentById() {
        Payment payment = new Payment();
        payment.setOrderId(1L);
        payment.setAmount(150.0);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("PAID");

        Payment savedPayment = paymentRepository.save(payment);

        Payment foundPayment = paymentRepository.findById(savedPayment.getId()).orElse(null);
        assertNotNull(foundPayment);
    }

    @Test
    public void testDeletePayment() {
        Payment payment = new Payment();
        payment.setOrderId(1L);
        payment.setAmount(250.0);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("PAID");

        Payment savedPayment = paymentRepository.save(payment);

        assertNotNull(paymentRepository.findById(savedPayment.getId()));

        paymentRepository.deleteById(savedPayment.getId());

        assertFalse(paymentRepository.findById(savedPayment.getId()).isPresent());
    }
}
