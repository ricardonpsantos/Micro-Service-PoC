package com.example.event_managment_service.repository;

import com.example.event_managment_service.Model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScoresRepository extends JpaRepository<Score,Long> {
    List<Score> findByEvent_Id(Integer eventId);
}
