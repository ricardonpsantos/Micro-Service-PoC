package com.example.event_managment_service.Service;

import com.example.event_managment_service.Controller.Dto.Request.Event.EventRequestDTO;
import com.example.event_managment_service.Controller.Dto.Response.Event.EventResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface EventService {
     List<EventResponseDTO> getAllEvents();

     EventResponseDTO getEventById(Long id);

     EventResponseDTO createEvent(EventRequestDTO eventRequestDTO);
}
