// PaymentRepository.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
