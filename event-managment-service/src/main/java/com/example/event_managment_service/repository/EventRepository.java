package com.example.event_managment_service.repository;

import com.example.event_managment_service.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
