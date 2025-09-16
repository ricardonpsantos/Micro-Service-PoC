package com.example.notification_managment_Service.Service;

import com.example.notification_managment_Service.Controller.Dto.Notification.RequestNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.ResponseNotificationDto;

import java.util.List;

public interface NotificationService {

    List<ResponseNotificationDto> getAllNotifications();
    ResponseNotificationDto getNotificationById(Integer id);
    List<ResponseNotificationDto> getNotificationByUserId(Integer id);
    ResponseNotificationDto createNewNotification(RequestNotificationDto requestNotificationDto);
    List<ResponseNotificationDto> sentNotification(int sizeToSent);

}
