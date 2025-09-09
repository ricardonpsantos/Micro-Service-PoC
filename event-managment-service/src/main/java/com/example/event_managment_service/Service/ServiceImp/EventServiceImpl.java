package com.example.event_managment_service.Service.ServiceImp;

import com.example.event_managment_service.Controller.Dto.Request.Event.AddRouteRequestDto;
import com.example.event_managment_service.Controller.Dto.Request.Event.ChangeRouteStatusRequestDto;
import com.example.event_managment_service.Controller.Dto.Request.Event.EventRequestDTO;
import com.example.event_managment_service.Controller.Dto.Request.Event.RemoveRouteRequestDto;
import com.example.event_managment_service.Controller.Dto.Response.Event.EventResponseDTO;
import com.example.event_managment_service.Controller.Dto.Response.Participants.ParticipantsResponseDto;
import com.example.event_managment_service.Exception.EventCancelledException;
import com.example.event_managment_service.Exception.NotFoundException;
import com.example.event_managment_service.Model.ClimbingRoute;
import com.example.event_managment_service.Model.Event;
import com.example.event_managment_service.Model.EventStatus;
import com.example.event_managment_service.Service.EventService;
import com.example.event_managment_service.mapper.EventMapper;
import com.example.event_managment_service.repository.ClimbingRouteRepository;
import com.example.event_managment_service.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.RouteMatcher;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ClimbingRouteRepository climbingRouteRepository;
    private final EventMapper eventMapper;

    public EventServiceImpl(EventRepository eventRepository, ClimbingRouteRepository climbingRouteRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.climbingRouteRepository = climbingRouteRepository;
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

    public EventResponseDTO addRoute(AddRouteRequestDto addRouteRequestDto) {
        ClimbingRoute climbingRoute = climbingRouteRepository.findById(Long.valueOf(addRouteRequestDto.getIdRoutes()))
                .orElseThrow(() -> new NotFoundException("This Climbing Route does not exist!"));

        Event event = eventRepository.findById(Long.valueOf(addRouteRequestDto.getIdEvent()))
                .orElseThrow(() -> new NotFoundException("This Event does not exist!"));

        if (!event.getStatus().isAllowChanges()) {
            throw new EventCancelledException("Event is cancelled!");
        }
        boolean routeAlreadyExists = event.getRoutes().stream()
                .anyMatch(route -> route.getId().equals(climbingRoute.getId()));

        if (routeAlreadyExists) {
            throw new IllegalArgumentException("Route already exists in this Event");
        }

        event.addRoutetoEvent(climbingRoute);
        eventRepository.save(event);

        EventResponseDTO eventResponseDTO = eventMapper.entityToResponseDto(event);

        return eventResponseDTO;
    }

    @Override
    public EventResponseDTO removeRoute(RemoveRouteRequestDto removeRouteRequestDto) {

        ClimbingRoute climbingRoute = climbingRouteRepository.findById(Long.valueOf(removeRouteRequestDto.getIdRoutes()))
                .orElseThrow(() -> new NotFoundException("This Climbing Route does not exist!"));

        Event event = eventRepository.findById(Long.valueOf(removeRouteRequestDto.getIdEvent()))
                .orElseThrow(() -> new NotFoundException("This Event does not exist!"));

        if (!event.getStatus().isAllowChanges()) {
            throw new EventCancelledException("Event is cancelled!");
        }

        boolean routeAlreadyExistsInEvent = event.getRoutes().stream()
                .anyMatch(route -> route.getId().equals(climbingRoute.getId()));

        if (!routeAlreadyExistsInEvent) {
            throw new IllegalArgumentException("Route not exists in this Event");
        }

        event.removeRouteFromEvent(climbingRoute);
        eventRepository.save(event);

        EventResponseDTO eventResponseDTO = eventMapper.entityToResponseDto(event);

        return eventResponseDTO;
    }

    public EventResponseDTO changeStatusEvent(ChangeRouteStatusRequestDto changeRouteStatusRequestDto) {

        Event event = eventRepository.findById(Long.valueOf(changeRouteStatusRequestDto.getIdEvent()))
                .orElseThrow(() -> new NotFoundException("This Event does not exist!"));

        if (!event.getStatus().isAllowChanges()) {
            throw new EventCancelledException("Event is cancelled!");
        }
        event.setStatus(EventStatus.fromIdentifyPermission(changeRouteStatusRequestDto.getIdChange()));

        return eventMapper.entityToResponseDto(eventRepository.save(event));

    }
}
