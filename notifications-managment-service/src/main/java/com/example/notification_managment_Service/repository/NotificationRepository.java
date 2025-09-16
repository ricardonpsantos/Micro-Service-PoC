package com.example.notification_managment_Service.repository;


import com.example.notification_managment_Service.Model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notifications, Long> {
    List<Notifications> findNotificationsByUserId(Long id);

    @Query(
            value = "SELECT * FROM notification WHERE notification_status = 'PENDING' ORDER BY notification_date ASC LIMIT :limit",
            nativeQuery = true)
    List<Notifications> findOldestNotifications(@Param("limit") int limit);
}
