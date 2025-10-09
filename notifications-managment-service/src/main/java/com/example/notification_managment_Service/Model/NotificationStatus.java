package com.example.notification_managment_Service.Model;

import lombok.Getter;

@Getter
public enum NotificationStatus {
    CREATE("Notification Criada", 1),
    PENDING("Aguardar", 1),
    CANCEL("Cancelada", 2),
    SENT("Enviada", 3),
    FAILED("Falhou", 4);

    private final String definition;
    private final int value;

    NotificationStatus(String definition, int value) {
        this.definition = definition;
        this.value = value;
    }
}
