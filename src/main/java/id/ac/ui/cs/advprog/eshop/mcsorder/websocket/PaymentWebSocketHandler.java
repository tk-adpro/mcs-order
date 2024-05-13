package id.ac.ui.cs.advprog.eshop.mcsorder.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class PaymentWebSocketHandler extends TextWebSocketHandler {

    @SuppressWarnings("null")
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        session.sendMessage(new TextMessage("Payment status updated: " + message.getPayload()));
    }
    
}
