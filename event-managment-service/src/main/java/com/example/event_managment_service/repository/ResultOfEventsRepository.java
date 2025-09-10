package com.example.event_managment_service.repository;

import com.example.event_managment_service.Model.ResultsOfEvents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultOfEventsRepository extends JpaRepository<ResultsOfEvents,Long> {
    List<ResultsOfEvents> findByEvent_id(Integer id);
}
