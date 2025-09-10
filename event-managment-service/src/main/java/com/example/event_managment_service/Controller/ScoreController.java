package com.example.event_managment_service.Controller;


import com.example.event_managment_service.Controller.Dto.Response.Event.EventDto;
import com.example.event_managment_service.Controller.Dto.Response.Score.ScoreResponseIdsAndNamesDto;
import com.example.event_managment_service.Service.ScoresService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final ScoresService scoresService;

    public ScoreController( ScoresService scoresService) {
        this.scoresService = scoresService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public Map<String, Map<String, List<ScoreResponseIdsAndNamesDto>>> getAllScores(){
        return scoresService.getAllScoresGrouped();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/event/{id}")
    public Map<String, Map<String, List<ScoreResponseIdsAndNamesDto>>> getAllScoresForeEventId(@RequestParam Integer id){
        return scoresService.getAllScoresForeEventId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/event/group/{id}")
    public List<EventDto> groupWell(@RequestParam Integer id){
        return scoresService.getScoresGrouped(id);
    }
}
