package com.example.event_managment_service.shared;

import lombok.extern.slf4j.*;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.*;

@Slf4j
@Component
public class UsersEventsListener {

    @RabbitListener(queues = EventsRabbitConfig.USERS_EVENTS_QUEUE)
    public void onUserCreated(UserCreatedEvent event) {
        try {
            if (event == null || event.userId() == null) {
                throw new IllegalArgumentException("Evento inválido");
            }

            // tua lógica: indexar, auditar, disparar workflows, etc.
            log.info("Recebi UserCreatedEvent: {}", event);

            // se tudo ok, AUTO ack resolve sozinho
        } catch (Exception ex) {
            // mandar para DLQ (sem requeue)
            throw new AmqpRejectAndDontRequeueException("Erro no processamento, vai para DLQ", ex);
        }
    }
}
