package com.example.notification_managment_Service.Controller.Dto.Notification;

public record EmailDataDto(
        String to,
        String title,
        String message
) {
}
