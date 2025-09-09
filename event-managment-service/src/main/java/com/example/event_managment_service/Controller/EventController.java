package com.example.event_managment_service.Controller;


import com.example.event_managment_service.Controller.Dto.Request.Event.AddRouteRequestDto;
import com.example.event_managment_service.Controller.Dto.Request.Event.ChangeRouteStatusRequestDto;
import com.example.event_managment_service.Controller.Dto.Request.Event.EventRequestDTO;
import com.example.event_managment_service.Controller.Dto.Request.Event.RemoveRouteRequestDto;
import com.example.event_managment_service.Controller.Dto.Response.Event.EventResponseDTO;
import com.example.event_managment_service.Service.EventService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventResponseDTO>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEventById(@RequestParam Long id) {
        return new ResponseEntity<>(eventService.getEventById(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<EventResponseDTO> createEvent( @Valid @RequestBody EventRequestDTO eventRequestDTO ) {
        return new ResponseEntity<>(eventService.createEvent(eventRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/add-route")
    public ResponseEntity<EventResponseDTO> addRoute( @Valid @RequestBody AddRouteRequestDto addRouteRequestDto ) {
        return new ResponseEntity<>(eventService.addRoute(addRouteRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/remove-route")
    public ResponseEntity<EventResponseDTO> removeRoute( @Valid @RequestBody RemoveRouteRequestDto removeRouteRequestDto ) {
        return new ResponseEntity<>(eventService.removeRoute(removeRouteRequestDto), HttpStatus.OK);
    }

    @PutMapping("/change-status")
    public ResponseEntity<EventResponseDTO> changeStatusEvent( @Valid @RequestBody ChangeRouteStatusRequestDto changeRouteStatusRequestDto ) {
        return new ResponseEntity<>(eventService.changeStatusEvent(changeRouteStatusRequestDto), HttpStatus.OK);
    }


}
