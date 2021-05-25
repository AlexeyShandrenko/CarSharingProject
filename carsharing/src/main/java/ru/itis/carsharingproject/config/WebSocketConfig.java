package ru.itis.carsharingproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.itis.carsharingproject.handlers.WebSocketHandshakeHandler;
import ru.itis.carsharingproject.handlers.WebSocketMessagesHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocketMessagesHandler messagesHandler;

    @Autowired
    private WebSocketHandshakeHandler handshakeHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(messagesHandler, "/chat").setHandshakeHandler(handshakeHandler);
    }


}
