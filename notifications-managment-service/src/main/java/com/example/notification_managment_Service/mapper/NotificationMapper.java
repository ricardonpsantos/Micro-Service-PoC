package com.example.notification_managment_Service.mapper;


import com.example.notification_managment_Service.Controller.Dto.Notification.RequestNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.ResponseNotificationDto;
import com.example.notification_managment_Service.Model.Notifications;
import org.mapstruct.Mapper;

import javax.swing.text.html.parser.Entity;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    Notifications dtoToEntity(RequestNotificationDto requestNotification);
    ResponseNotificationDto entityToDto(Notifications notifications);
}


