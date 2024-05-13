// PaymentRepository.java
package id.ac.ui.cs.advprog.eshop.mcsorder.repository;

import id.ac.ui.cs.advprog.eshop.mcsorder.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
