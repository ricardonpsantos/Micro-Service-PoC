package com.example.notification_managment_Service.Service.ServiceImp;

import com.example.notification_managment_Service.Model.EventLog;
import com.example.notification_managment_Service.Service.EventLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventLogServiceImpl implements EventLogService {

    private final EventLogRepository eventLogRepository;

    public EventLogServiceImpl(EventLogRepository eventLogRepository) {
        this.eventLogRepository = eventLogRepository;
    }

    @Override
    public List<EventLog> getAllEvents() {
        return eventLogRepository.findAll();
    }
}
