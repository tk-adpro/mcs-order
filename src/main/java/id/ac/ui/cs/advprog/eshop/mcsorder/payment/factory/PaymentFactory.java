// PaymentFactory.java

package id.ac.ui.cs.advprog.eshop.mcsorder.payment.factory;

import java.time.LocalDateTime;

import id.ac.ui.cs.advprog.eshop.mcsorder.payment.model.Payment;

public class PaymentFactory {

    public static Payment createPayment(Long orderId, double amount, String status, String validationStatus) {
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus(status);
        payment.setValidationStatus(validationStatus);
        return payment;
    }
}
