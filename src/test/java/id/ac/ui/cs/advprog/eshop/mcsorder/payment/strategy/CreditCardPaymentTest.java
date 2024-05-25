// CreditCardPaymentTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardPaymentTest {

    @Test
    void testPay() {
        String cardNumber = "1234-5678-9876-5432";
        String cardHolderName = "John Doe";
        String cardExpiryDate = "12/23";
        double amount = 100.0;

        CreditCardPayment payment = new CreditCardPayment(cardNumber, cardHolderName, cardExpiryDate);

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        payment.pay(amount);

        String expectedOutput = "Paid " + amount + " using Credit Card.\n" +
                                "Card Holder: " + cardHolderName + ", Card Number: " + cardNumber + ", Expiry Date: " + cardExpiryDate + "\n";
        assertEquals(expectedOutput, outContent.toString());

        // Reset the output stream
        System.setOut(System.out);
    }
}