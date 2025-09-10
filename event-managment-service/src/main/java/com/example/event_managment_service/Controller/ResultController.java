package com.example.event_managment_service.Controller;


import com.example.event_managment_service.Controller.Dto.Response.ResultOfEvents.ResultofEventsDto;
import com.example.event_managment_service.Service.ResultsOfEventsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {

    private final ResultsOfEventsService eventsService;

    public ResultController(ResultsOfEventsService eventsService) {
        this.eventsService = eventsService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/event/{id}")
    public ResultofEventsDto getScoresByEvent(@PathVariable Integer id){
        return eventsService.getScoresByEvent(id);
    }
}
