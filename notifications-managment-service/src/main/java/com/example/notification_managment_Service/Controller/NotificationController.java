package com.example.notification_managment_Service.Controller;

import com.example.notification_managment_Service.Controller.Dto.Notification.ResponseNotificationDto;
import com.example.notification_managment_Service.Service.NotificationService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<ResponseNotificationDto> getAllNotification() {
        return service.getAllNotifications();
    }

}



