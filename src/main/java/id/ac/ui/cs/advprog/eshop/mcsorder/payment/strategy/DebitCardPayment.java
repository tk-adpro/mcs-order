package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

public class DebitCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Debit Card.");
    }
}
