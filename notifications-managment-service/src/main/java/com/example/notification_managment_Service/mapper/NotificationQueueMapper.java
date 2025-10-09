package com.example.notification_managment_Service.mapper;


import com.example.notification_managment_Service.Controller.Dto.Notification.EmailDataDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.RequestNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.ResponseNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.StatusNotificationDto;
import com.example.notification_managment_Service.Model.Notifications;
import com.example.notification_managment_Service.Model.NotificationsQueue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationQueueMapper {


    @Mapping(target = "to", source = "notification.to")
    @Mapping(target = "title", source = "notification.title")
    @Mapping(target = "message", source = "notification.message")
    EmailDataDto convertNotificationToQueueDto(NotificationsQueue notificationsQueue);


}


