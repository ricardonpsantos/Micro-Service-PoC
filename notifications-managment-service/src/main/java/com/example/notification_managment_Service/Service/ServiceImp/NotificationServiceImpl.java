package com.example.notification_managment_Service.Service.ServiceImp;

import com.example.notification_managment_Service.Controller.Dto.Notification.RequestNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.ResponseNotificationDto;
import com.example.notification_managment_Service.Exception.NotFoundException;
import com.example.notification_managment_Service.Model.NotificationStatus;
import com.example.notification_managment_Service.Model.Notifications;
import com.example.notification_managment_Service.Service.NotificationService;
import com.example.notification_managment_Service.mapper.NotificationMapper;
import com.example.notification_managment_Service.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;


    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }


    public List<ResponseNotificationDto> getAllNotifications() {
        return notificationRepository.findAll()
                .stream()
                .filter(s -> s.getIdNotification() != null)
                .map(notificationMapper::entityToDto)
                .toList();
    }

    public ResponseNotificationDto getNotificationById(Integer id) {
        return notificationRepository.findById(Long.valueOf(id))
                .map(notificationMapper::entityToDto)
                .orElseThrow(() -> new NotFoundException("Notification :" + id + " Not Found"));
    }

    public List<ResponseNotificationDto> getNotificationByUserId(Integer id) {
        List<Notifications> notifications = notificationRepository.findNotificationsByUserId(Long.valueOf(id));

        if (notifications.isEmpty()) {
            throw new NotFoundException("No notifications found for userId: " + id);
        }

        return notifications.stream()
                .map(notificationMapper::entityToDto)
                .toList();
    }

    @Transactional
    public ResponseNotificationDto createNewNotification(RequestNotificationDto requestNotificationDto) {
        Notifications notifications = notificationMapper.dtoToEntity(requestNotificationDto);
        notifications.setNotificationStatus(NotificationStatus.PENDING);
        notifications.setNotificationCreate(LocalDateTime.now());
        return notificationMapper.entityToDto(notificationRepository.save(notifications));
    }



    public List<ResponseNotificationDto> sentNotification(int sizeToSent) {
        List<Notifications> listSent = notificationRepository.findOldestNotifications(sizeToSent);
        if (listSent.isEmpty()) {
            throw new NotFoundException("NOT EXIST NOTIFICATIONS");
        }
        listSent.forEach(s -> {
            s.setNotificationStatus(NotificationStatus.SENT);
            s.setNotificationSent(LocalDateTime.now());
        });

        notificationRepository.saveAll(listSent);

        return listSent.stream().map(notificationMapper::entityToDto).toList();

    }
}