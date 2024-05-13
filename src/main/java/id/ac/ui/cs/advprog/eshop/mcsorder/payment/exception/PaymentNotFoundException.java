// PaymentNotFoundException.java

package id.ac.ui.cs.advprog.eshop.mcsorder.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(Long id) {
        super("Payment with ID " + id + " not found.");
    }
}
