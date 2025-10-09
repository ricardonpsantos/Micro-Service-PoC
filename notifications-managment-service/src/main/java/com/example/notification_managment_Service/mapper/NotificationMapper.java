package com.example.notification_managment_Service.mapper;


import com.example.notification_managment_Service.Controller.Dto.Notification.StatusNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.RequestNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.ResponseNotificationDto;
import com.example.notification_managment_Service.Model.Notifications;
import com.example.notification_managment_Service.Model.NotificationsQueue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {



    Notifications dtoRequestToEntity(RequestNotificationDto requestNotification);
    ResponseNotificationDto entityToDtoResponse(Notifications notifications);

    @Mapping(target = "message", source = "status")
    StatusNotificationDto confirmNotification(Notifications notifications);

    @Mapping(target = "idNotificationqueue", ignore = true)
    @Mapping(target = "processedDate", ignore = true)
    @Mapping(target = "attemptCount", constant = "0")
    @Mapping(target = "locked", constant = "false")
    NotificationsQueue convertNotificationToQueueDto(Notifications notifications);


}


