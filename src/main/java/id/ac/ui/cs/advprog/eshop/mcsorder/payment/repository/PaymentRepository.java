// PaymentRepository.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
