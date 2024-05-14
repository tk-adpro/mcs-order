// OrderWebSocketHandlerTest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.websocket;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class OrderWebSocketHandlerTest {

    private OrderWebSocketHandler orderWebSocketHandler;
    private WebSocketSession session;

    @BeforeEach
    public void setUp() {
        orderWebSocketHandler = new OrderWebSocketHandler();
        session = mock(WebSocketSession.class);
    }

    @Test
    public void testHandleTextMessage() throws Exception {
        String payload = "Order123";
        TextMessage message = new TextMessage(payload);

        orderWebSocketHandler.handleTextMessage(session, message);

        verify(session, times(1)).sendMessage(new TextMessage("Order status updated: " + payload));
    }
}