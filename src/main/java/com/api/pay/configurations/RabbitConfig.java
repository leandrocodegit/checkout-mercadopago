package com.api.pay.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Binding purchaseBinging(){
        return  BindingBuilder
                .bind(purchasesModelQueue())
            .to( directExchange())
            .with("")
            .noargs();
    }
    @Bean
    public Exchange directExchange(){
        return  ExchangeBuilder
            .directExchange("QUEUE_NOTIFICACAO-PAYMENT")
            .durable(true)
            .build();
    }

    @Bean
    public Queue purchasesModelQueue(){
        return QueueBuilder.durable("QUEUE_NOTIFICACAO-PAYMENT").build();
    }

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}