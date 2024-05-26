// GopayPayment.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

public class GopayPayment implements PaymentStrategy {
    private String gopayId;

    public GopayPayment(String gopayId) {
        this.gopayId = gopayId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using GoPay.");
        System.out.println("GoPay ID: " + gopayId);
    }
}
