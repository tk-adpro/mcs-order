// PayPalPaymentTest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PayPalPaymentTest {

    @Test
    void testPay() {
        String email = "john.doe@example.com";
        String password = "password";
        double amount = 250.0;

        PayPalPayment payment = new PayPalPayment(email, password);

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        payment.pay(amount);

        String expectedOutput = "Paid " + amount + " using PayPal.\n" +
                                "Email: " + email + "\n";
        assertEquals(expectedOutput, outContent.toString());

        // Reset the output stream
        System.setOut(System.out);
    }
}