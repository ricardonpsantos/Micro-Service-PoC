package com.example.event_managment_service.shared;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.*;

@Configuration
public class EventsRabbitConfig {

    public static final String DOMAIN_EXCHANGE = "app.domain";

    // filas específicas deste serviço
    public static final String USERS_EVENTS_QUEUE = "events.users.q";
    public static final String USERS_EVENTS_DLQ   = "events.users.dlq";
    public static final String DLX               = "app.dlx";

    @Bean
    public TopicExchange domainExchange() {
        return new TopicExchange(DOMAIN_EXCHANGE, true, false);
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(DLX, true, false);
    }

    @Bean
    public Queue usersEventsQueue() {
        return QueueBuilder.durable(USERS_EVENTS_QUEUE)
                .withArgument("x-dead-letter-exchange", DLX)
                .withArgument("x-dead-letter-routing-key", USERS_EVENTS_DLQ)
                .build();
    }

    @Bean
    public Queue usersEventsDlq() {
        return QueueBuilder.durable(USERS_EVENTS_DLQ).build();
    }

    @Bean
    public Binding usersEventsBinding() {
        // consome TODOS os eventos do domínio users.*
        return BindingBuilder
                .bind(usersEventsQueue())
                .to(domainExchange())
                .with("users.*");
    }

    @Bean
    public Binding usersDlqBinding() {
        return BindingBuilder
                .bind(usersEventsDlq())
                .to(deadLetterExchange())
                .with(USERS_EVENTS_DLQ);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper mapper) {
        return new Jackson2JsonMessageConverter(mapper);
    }
}
