package com.example.notification_managment_Service.repository;

import com.example.notification_managment_Service.Model.NotificationsQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationsQueueRepository extends JpaRepository<NotificationsQueue,Integer> {


    @Query("SELECT a FROM NotificationsQueue a WHERE a.scheduledDate > CURRENT_TIMESTAMP and ")
    List<NotificationsQueue> findAllToProcess();
}
