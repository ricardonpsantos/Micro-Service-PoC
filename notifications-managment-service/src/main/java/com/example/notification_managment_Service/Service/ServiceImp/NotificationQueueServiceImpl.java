package com.example.notification_managment_Service.Service.ServiceImp;

import com.example.notification_managment_Service.Controller.Dto.Notification.EmailDataDto;
import com.example.notification_managment_Service.Exception.NotFoundException;
import com.example.notification_managment_Service.Model.*;
import com.example.notification_managment_Service.Service.NotificationQueueService;
import com.example.notification_managment_Service.mapper.NotificationQueueMapper;
import com.example.notification_managment_Service.repository.NotificationRepository;
import com.example.notification_managment_Service.repository.NotificationsQueueRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class NotificationQueueServiceImpl implements NotificationQueueService {

    private final NotificationsQueueRepository queueRepository;
    private final NotificationQueueMapper notificationQueueMapper;
    private final NotificationRepository notificationRepository;

    @Value("${variables.max-attemps-send-email}")
    private Integer maxAttempts;

    public NotificationQueueServiceImpl(NotificationsQueueRepository queueRepository, NotificationQueueMapper notificationQueueMapper, NotificationRepository notificationRepository) {
        this.queueRepository = queueRepository;
        this.notificationQueueMapper = notificationQueueMapper;
        this.notificationRepository = notificationRepository;
    }


    @Transactional(readOnly = true)
    public void processNotificationsQueue() {
        List<NotificationsQueue> listToProcess = getAllNotificationsToProcess();
        if (!listToProcess.isEmpty()) {
            for (NotificationsQueue item : listToProcess) {
                processSingleItem(item);
            }
        }

    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void processSingleItem(NotificationsQueue nq) {
        if (nq == null || nq.getNotification() == null) {
            return;
        }

        System.out.println("PROCESSING NOTIFICATION ID: " + nq.getNotification().getIdNotification());
        if (nq.isLocked()) return;
        nq.setLocked(true);
        queueRepository.save(nq);

        try {
            Notifications notif = nq.getNotification();
            NotificationType type = notif.getType();

            if (type != NotificationType.EMAIL) {
                nq.setLocked(false);
                queueRepository.save(nq);
                return;
            }

            EmailDataDto dataToSend = notificationQueueMapper.convertNotificationToQueueDto(nq);

            boolean sentNotification = false;
            int attempts = nq.getAttemptCount();

            while (attempts < maxAttempts && !sentNotification) {
                try {
                    sentNotification = sendEmailNotification(dataToSend);
                } catch (Exception e) {
                    sentNotification = false;
                }

                attempts++;
                nq.setAttemptCount(attempts);
                queueRepository.save(nq);
            }

            if (sentNotification) {
                Notifications n = notificationRepository.findById(notif.getIdNotification())
                        .orElseThrow(() -> new NotFoundException(
                                NotificationMessage.NOT_FOUND.getMessage() + ": " + notif.getIdNotification()));

                sentSuccess(n, nq);
            } else {
                notif.setStatus(NotificationStatus.FAILED);
                notif.setFeedbackMessage("Max attempts reached: " + maxAttempts);
                notificationRepository.save(notif);

                nq.setProcessedDate(LocalDateTime.now());
                nq.setLocked(false);
                queueRepository.save(nq);
            }
        } finally {
            if (nq.isLocked()) {
                nq.setLocked(false);
                queueRepository.save(nq);
            }
        }
    }

    private List<NotificationsQueue> getAllNotificationsToProcess() {
        return queueRepository.findAllToProcess();
    }


    private boolean sendEmailNotification(EmailDataDto emailDataDto) {
        // TODO: integrar com o teu provider (SMTP/SES/etc.)
        // return mailClient.send(emailDataDto);
        return false;
    }

    private void sentSuccess(Notifications n, NotificationsQueue s) {
        n.setStatus(NotificationStatus.SENT);
        n.setSentAt(LocalDateTime.now());
        n.setFeedbackMessage(NotificationMessage.SENT.getMessage());
        notificationRepository.save(n);

        s.setProcessedDate(LocalDateTime.now());
        s.setLocked(false);
        queueRepository.delete(s);
    }
}
