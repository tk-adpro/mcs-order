// PaymentContext.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        strategy.pay(amount);
    }
}