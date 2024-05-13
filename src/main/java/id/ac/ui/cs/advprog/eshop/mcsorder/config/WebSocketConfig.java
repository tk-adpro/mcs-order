package id.ac.ui.cs.advprog.eshop.mcsorder.config;

import id.ac.ui.cs.advprog.eshop.mcsorder.websocket.OrderWebSocketHandler;
import id.ac.ui.cs.advprog.eshop.mcsorder.websocket.PaymentWebSocketHandler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    
    @Override
    public void registerWebSocketHandlers(@SuppressWarnings("null") WebSocketHandlerRegistry registry) {
        registry.addHandler(new OrderWebSocketHandler(), "/ws/order")
                .setAllowedOrigins("*");
        registry.addHandler(new PaymentWebSocketHandler(), "/ws/payment")
                .setAllowedOrigins("*");
    }
}
