// CustomerNotifierTest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerNotifierTest {

    private CustomerNotifier customerNotifier;
    private String customerEmail = "customer@example.com";

    @BeforeEach
    public void setUp() {
        customerNotifier = new CustomerNotifier(customerEmail);
    }

    @Test
    public void testUpdate() {
        String status = "Shipped";

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        customerNotifier.update(status);

        String expectedOutput = "Notifying " + customerEmail + " about order status: " + status + "\n";
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(System.out);
    }
}