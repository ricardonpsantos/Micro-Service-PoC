package com.example.notification_managment_Service.Service;

import com.example.notification_managment_Service.Controller.Dto.Notification.RequestNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.ResponseNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.StatusNotificationDto;

import java.util.List;

public interface NotificationService {

    List<ResponseNotificationDto> getAllNotifications();
    StatusNotificationDto receiveNotification(RequestNotificationDto requestNotificationDto);



}
