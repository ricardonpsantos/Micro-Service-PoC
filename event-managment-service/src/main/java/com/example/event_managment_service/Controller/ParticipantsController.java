package com.example.event_managment_service.Controller;

import com.example.event_managment_service.Controller.Dto.Response.Participants.ParticipantsResponseDto;
import com.example.event_managment_service.Service.EventService;
import com.example.event_managment_service.Service.ParticipantsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantsController {

    private final ParticipantsService participantsService;
    private final EventService eventService;

    public ParticipantsController(ParticipantsService participantsService, EventService eventService) {
        this.participantsService = participantsService;
        this.eventService = eventService;
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retorna todas os Participants")
    @GetMapping("/all")
    public ResponseEntity<List<ParticipantsResponseDto>> getAllParticipants() {
        return new ResponseEntity<>(participantsService.getAllParticipants(), HttpStatus.OK);
    }

}
