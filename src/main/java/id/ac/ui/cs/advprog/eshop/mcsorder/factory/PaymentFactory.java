// PaymentFactory.java

package id.ac.ui.cs.advprog.eshop.mcsorder.factory;

import id.ac.ui.cs.advprog.eshop.mcsorder.model.Payment;

import java.time.LocalDateTime;

// TODO: Parameternya bisa diubah, tergantung kebutuhan
public class PaymentFactory {

    public static Payment createPayment(Long orderId, double amount, String status) {
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus(status);
        return payment;
    }
}
