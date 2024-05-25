// GopayPaymentTest.java
package id.ac.ui.cs.advprog.eshop.mcsorder.payment.strategy;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GopayPaymentTest {

    @Test
    void testPay() {
        String gopayId = "GOPAY-12345";
        double amount = 200.0;

        GopayPayment payment = new GopayPayment(gopayId);

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        payment.pay(amount);

        String expectedOutput = "Paid " + amount + " using GoPay.\n" +
                                "GoPay ID: " + gopayId + "\n";
        assertEquals(expectedOutput, outContent.toString());

        // Reset the output stream
        System.setOut(System.out);
    }
}
