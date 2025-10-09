package com.example.notification_managment_Service.Model;

import lombok.Getter;

@Getter
public enum NotificationType {
    EMAIL("Notificação Enviada por Email"),
    SMS("Notificação Enviada por Sms");

    private final String description;

    NotificationType(String description) {
        this.description = description;
    }


}
