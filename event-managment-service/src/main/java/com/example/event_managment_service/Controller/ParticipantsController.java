package com.example.event_managment_service.Controller;

import com.example.event_managment_service.Controller.Dto.Response.ParticipantsResponseDto;
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

    public ParticipantsController(ParticipantsService participantsService) {
        this.participantsService = participantsService;
    }

    @Operation(summary = "Retorna todas os Participants")
    @GetMapping("/all")
    public ResponseEntity<List<ParticipantsResponseDto>> getAllRoles() {
        return new ResponseEntity<>(participantsService.getAllParticipants(), HttpStatus.OK);
    }
}
