// PayPalPayment.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email, String password) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
        System.out.println("Email: " + email);
    }
}
