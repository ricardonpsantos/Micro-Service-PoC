package com.example.notification_managment_Service.Model;

public enum NotificationType {
    EMAIL("Notificação Enviada por Email")
    ,SMS("Notificação Enviada por Email");

    private final String description;

    NotificationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
