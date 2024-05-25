package id.ac.ui.cs.advprog.eshop.mcsorder.config;

import id.ac.ui.cs.advprog.eshop.mcsorder.websocket.OrderWebSocketHandler;
import id.ac.ui.cs.advprog.eshop.mcsorder.websocket.PaymentWebSocketHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import static org.mockito.Mockito.*;

class WebSocketConfigTest {

    @Mock
    private WebSocketHandlerRegistry registry;

    @InjectMocks
    private WebSocketConfig webSocketConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterWebSocketHandlers() {
        doNothing().when(registry).addHandler(any(OrderWebSocketHandler.class), eq("/ws/order")).setAllowedOrigins("*");
        doNothing().when(registry).addHandler(any(PaymentWebSocketHandler.class), eq("/ws/payment")).setAllowedOrigins("*");

        webSocketConfig.registerWebSocketHandlers(registry);

        verify(registry, times(1)).addHandler(any(OrderWebSocketHandler.class), eq("/ws/order"));
        verify(registry, times(1)).addHandler(any(PaymentWebSocketHandler.class), eq("/ws/payment"));
    }
}