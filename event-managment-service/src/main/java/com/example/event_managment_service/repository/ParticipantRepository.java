package com.example.event_managment_service.repository;

import com.example.event_managment_service.Model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant,Long> {

}
