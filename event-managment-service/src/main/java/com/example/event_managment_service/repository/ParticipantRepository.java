package com.example.event_managment_service.repository;

import com.example.event_managment_service.Model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
