package edu.usc.csci.boneapptheteeth;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebPageConfiguration implements WebSocketMessageBrokerConfigurer {
    //enable an in-memory message broker to carry the messages
    //back to the client on destinations prefixed with “/topic”.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

//designate all routes that are subscriptions from the client with this prefix
        config.enableSimpleBroker("/topic");
    }

//    this part tells dispatch to pass it to mesageBroker
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //for websockets connection
        registry.addEndpoint("/interaction");
        registry.addEndpoint("/interaction").withSockJS();
    }
}