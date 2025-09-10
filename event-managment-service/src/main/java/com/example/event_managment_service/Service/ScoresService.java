package com.example.event_managment_service.Service;

import com.example.event_managment_service.Controller.Dto.Response.Event.EventDto;
import com.example.event_managment_service.Controller.Dto.Response.Score.ScoreResponseOnlyIdsDto;

import java.util.List;
import java.util.Map;

public interface ScoresService {
    Map<String, Map<String, List<ScoreResponseOnlyIdsDto>>> getAllScoresGrouped();

    Map<String, Map<String, List<ScoreResponseOnlyIdsDto>>> getAllScoresForeEventId(Integer id);

    List<EventDto> getScoresGrouped(Integer id);

}
