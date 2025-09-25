package com.example.notification_managment_Service.Service;

import com.example.notification_managment_Service.Controller.EventLogController;
import com.example.notification_managment_Service.Model.EventLog;

import java.util.List;

public interface EventLogService {
    List<EventLog> getAllEvents();
}
