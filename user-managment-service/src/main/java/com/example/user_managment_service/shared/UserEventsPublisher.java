package com.example.user_managment_service.shared;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEventsPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void userCreated(UserCreatedEvent event) {
        rabbitTemplate.convertAndSend(
                UsersRabbitConfig.DOMAIN_EXCHANGE,
                "users.created",
                event,
                msg -> {
                    msg.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    return msg;
                }
        );
    }
}
