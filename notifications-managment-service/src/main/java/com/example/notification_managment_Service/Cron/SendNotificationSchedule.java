package com.example.notification_managment_Service.Cron;

import com.example.notification_managment_Service.Service.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SendNotificationSchedule {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final NotificationService notificationService;

    public SendNotificationSchedule(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        notificationService.sentNotification(5);
    }
}
