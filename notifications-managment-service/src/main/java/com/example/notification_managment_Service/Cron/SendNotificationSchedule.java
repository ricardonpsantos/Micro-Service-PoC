package com.example.notification_managment_Service.Cron;

import com.example.notification_managment_Service.Service.NotificationQueueService;
import com.example.notification_managment_Service.Service.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SendNotificationSchedule {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final NotificationQueueService notificationQueueService;

    public SendNotificationSchedule(NotificationQueueService notificationQueueService) {
        this.notificationQueueService = notificationQueueService;
    }

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        notificationQueueService.processNotificationsQueue();
    }
}
