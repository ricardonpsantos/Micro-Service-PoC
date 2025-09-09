package com.example.event_managment_service.Service;

import com.example.event_managment_service.Controller.Dto.Request.Event.AddRouteRequestDto;
import com.example.event_managment_service.Controller.Dto.Request.Event.ChangeRouteStatusRequestDto;
import com.example.event_managment_service.Controller.Dto.Request.Event.EventRequestDTO;
import com.example.event_managment_service.Controller.Dto.Request.Event.RemoveRouteRequestDto;
import com.example.event_managment_service.Controller.Dto.Response.Event.EventResponseDTO;
import com.example.event_managment_service.Controller.Dto.Response.Participants.ParticipantsResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface EventService {
     List<EventResponseDTO> getAllEvents();

     EventResponseDTO getEventById(Long id);

     EventResponseDTO createEvent(EventRequestDTO eventRequestDTO);

    EventResponseDTO addRoute(AddRouteRequestDto addRouteRequestDto);

    EventResponseDTO removeRoute(RemoveRouteRequestDto removeRouteRequestDto);

    EventResponseDTO changeStatusEvent(ChangeRouteStatusRequestDto changeRouteStatusRequestDto);
}
