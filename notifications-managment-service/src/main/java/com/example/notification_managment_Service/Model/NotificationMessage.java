package com.example.notification_managment_Service.Model;

import lombok.Getter;

@Getter
public enum NotificationMessage {


    EXIST("Notificação igual já foi criada, tente mais tarde"),
    SENT("Notificação Enviada"),
    NOT_FOUND("Notificação não encontrada");

    private final String message;

    NotificationMessage(String message){
        this.message =message;
    }

}
