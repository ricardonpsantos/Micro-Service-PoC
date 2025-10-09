package com.example.notification_managment_Service.Service.ServiceImp;
import com.example.notification_managment_Service.Exception.AlreadyExistException;
import com.example.notification_managment_Service.Model.NotificationMessage;
import com.example.notification_managment_Service.Model.NotificationStatus;
import com.example.notification_managment_Service.Model.NotificationsQueue;
import com.example.notification_managment_Service.repository.NotificationsQueueRepository;
import org.springframework.beans.factory.annotation.Value;
import com.example.notification_managment_Service.Controller.Dto.Notification.StatusNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.RequestNotificationDto;
import com.example.notification_managment_Service.Controller.Dto.Notification.ResponseNotificationDto;
import com.example.notification_managment_Service.Model.Notifications;
import com.example.notification_managment_Service.Service.NotificationService;
import com.example.notification_managment_Service.mapper.NotificationMapper;
import com.example.notification_managment_Service.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationsQueueRepository notificationsQueueRepository;
    private final NotificationMapper notificationMapper;

    @Value("${variables.min-check-duplicate}")
    private Integer days;


    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationsQueueRepository notificationsQueueRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationsQueueRepository = notificationsQueueRepository;
        this.notificationMapper = notificationMapper;
    }


    public List<ResponseNotificationDto> getAllNotifications() {
        return notificationRepository.findAll()
                .stream()
                .filter(s -> s.getIdNotification() != null)
                .map(notificationMapper::entityToDtoResponse)
                .toList();
    }

    @Transactional
    public StatusNotificationDto receiveNotification(RequestNotificationDto requestNotificationDto) {
        Notifications notifications = notificationMapper.dtoRequestToEntity(requestNotificationDto);
        if(checkIfNotificationAlreadyExist(notifications)){
            throw new AlreadyExistException(NotificationMessage.EXIST.getMessage());
        }
        notificationRepository.save(notifications);
        processNotification(notifications);
        return notificationMapper.confirmNotification(notifications);
    }

    @Transactional
    private void processNotification(Notifications notifications) {

        NotificationsQueue nq = notificationMapper.convertNotificationToQueueDto(notifications);

        notifications.setStatus(NotificationStatus.PENDING);
        notificationsQueueRepository.save(nq);
        notificationRepository.save(notifications);
    }


    public boolean checkIfNotificationAlreadyExist(Notifications notifications) {

        List<Notifications> notificationUserList = notificationRepository.findNotificationsByUserId(notifications.getUserId());
        if (notificationUserList.isEmpty()) {
            return false;
        }

        List<Notifications> checkDuplicates = notificationUserList.stream()
                .filter(s -> {
                    long diffMinutes = Duration.between(s.getCreatedAt(), notifications.getCreatedAt()).toMinutes();
                    return diffMinutes < days;
                })
                .filter(s ->
                        s.getUserId().equals(notifications.getUserId()) &&
                                s.getMessage().equals(notifications.getMessage()) &&
                                s.getTitle().equals(notifications.getTitle())
                )
                .toList();

        return !checkDuplicates.isEmpty();

    }


}