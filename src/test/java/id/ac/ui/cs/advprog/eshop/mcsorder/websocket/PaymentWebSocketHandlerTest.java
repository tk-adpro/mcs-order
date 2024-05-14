// PaymentWebSocketHandlerTest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.websocket;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class PaymentWebSocketHandlerTest {

    private PaymentWebSocketHandler paymentWebSocketHandler;
    private WebSocketSession session;

    @BeforeEach
    public void setUp() {
        paymentWebSocketHandler = new PaymentWebSocketHandler();
        session = mock(WebSocketSession.class);
    }

    @Test
    public void testHandleTextMessage() throws Exception {
        String payload = "Payment123";
        TextMessage message = new TextMessage(payload);

        paymentWebSocketHandler.handleTextMessage(session, message);

        verify(session, times(1)).sendMessage(new TextMessage("Payment status updated: " + payload));
    }
}