package com.example.event_managment_service.Service.ServiceImp;

import com.example.event_managment_service.Controller.Dto.Request.Event.EventRequestDTO;
import com.example.event_managment_service.Controller.Dto.Response.Event.EventResponseDTO;
import com.example.event_managment_service.Exception.NotFoundException;
import com.example.event_managment_service.Service.EventService;
import com.example.event_managment_service.mapper.EventMapper;
import com.example.event_managment_service.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public List<EventResponseDTO> getAllEvents() {
        List<EventResponseDTO> eventResponseDTOList = eventRepository.findAll()
                .stream()
                .map(eventMapper::entityToResponseDto)
                .toList();

        if (eventResponseDTOList.isEmpty()) {
            throw new NotFoundException("Events not found");
        }
        return eventResponseDTOList;
    }

    public EventResponseDTO getEventById(Long id) {
        return eventRepository.findById(id)
                .map(eventMapper::entityToResponseDto)
                .orElseThrow(() -> new NotFoundException("Event with id " + id + " not found"));
    }

    public EventResponseDTO createEvent(EventRequestDTO eventRequestDTO) {
        return eventMapper.entityToResponseDto(eventRepository.save(eventMapper.requestToentityDto(eventRequestDTO)));
    }
}
