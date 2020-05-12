package org.javaboy.vhr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker   //此注解开启WebSocket消息代理
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //定义一个前缀为“/ws/ep”的endPoit，并开启sockjs支持，sockjs可以解决浏览器对WebSocket的兼容性，
        //客户端将通过这里配置的URL来建立WebSocket连接
        registry.addEndpoint("/ws/ep").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /*设置消息代理的前缀，如果消息的前缀是“/queue”，则会将消息转发给消息代理（broker），
        之后再由消息代理将消息广播给当前连接的客户端*/
        registry.enableSimpleBroker("/queue");
    }
}
