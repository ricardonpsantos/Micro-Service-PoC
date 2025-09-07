package com.example.event_managment_service.Controller;


import com.example.event_managment_service.Controller.Dto.Request.Event.EventRequestDTO;
import com.example.event_managment_service.Controller.Dto.Response.Event.EventResponseDTO;
import com.example.event_managment_service.Service.EventService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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


}
