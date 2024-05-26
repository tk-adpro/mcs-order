// PaymentRepository.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByValidationStatus(String validationStatus);
}
