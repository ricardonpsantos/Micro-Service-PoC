package com.example.notification_managment_Service.repository;

import com.example.notification_managment_Service.Controller.EventLogController;
import com.example.notification_managment_Service.Model.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventLogRepository extends JpaRepository<EventLog,Integer> {
}
