package com.example.notification_managment_Service.Controller.Dto.Notification;

import com.example.notification_managment_Service.Model.NotificationStatus;
import com.example.notification_managment_Service.Model.NotificationType;

import java.time.LocalDateTime;

public record ResponseNotificationSent(
        Integer userId,
        NotificationType notificationType,
        String title,
        String message,
        NotificationStatus notificationStatus,
        LocalDateTime notificationCreate,
        LocalDateTime notificationSent
) {
}
