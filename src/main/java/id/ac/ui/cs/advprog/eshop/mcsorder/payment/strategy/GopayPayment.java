// GopayPayment.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

public class GopayPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Gopay.");
    }
}
