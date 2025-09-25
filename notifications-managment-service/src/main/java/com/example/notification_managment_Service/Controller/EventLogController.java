package com.example.notification_managment_Service.Controller;

import com.example.notification_managment_Service.Controller.Dto.Notification.ResponseNotificationDto;
import com.example.notification_managment_Service.Model.EventLog;
import com.example.notification_managment_Service.Service.EventLogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/logging")
public class EventLogController {

    private final EventLogService eventLogService;

    public EventLogController(EventLogService eventLogService) {
        this.eventLogService = eventLogService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<EventLog> getAllNotification() {
        return eventLogService.getAllEvents();
    }
}
