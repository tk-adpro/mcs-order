// DebitCardPaymentTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DebitCardPaymentTest {

    @Test
    void testPay() {
        String cardNumber = "4321-8765-6789-2345";
        String cardHolderName = "Jane Doe";
        String cardExpiryDate = "11/24";
        double amount = 150.0;

        DebitCardPayment payment = new DebitCardPayment(cardNumber, cardHolderName, cardExpiryDate);

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        payment.pay(amount);

        String expectedOutput = "Paid " + amount + " using Debit Card.\n" +
                                "Card Holder: " + cardHolderName + ", Card Number: " + cardNumber + ", Expiry Date: " + cardExpiryDate + "\n";
        assertEquals(expectedOutput, outContent.toString());

        // Reset the output stream
        System.setOut(System.out);
    }
}