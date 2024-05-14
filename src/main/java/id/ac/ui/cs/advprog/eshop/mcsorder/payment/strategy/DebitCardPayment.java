// DebitCardPayment.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

public class DebitCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cardExpiryDate;

    public DebitCardPayment(String cardNumber, String cardHolderName, String cardExpiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardExpiryDate = cardExpiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Debit Card.");
        System.out.println("Card Holder: " + cardHolderName + ", Card Number: " + cardNumber + ", Expiry Date: " + cardExpiryDate);
    }
}
