package com.example.event_managment_service.Service;

import com.example.event_managment_service.Controller.Dto.Response.ResultOfEvents.ResultofEventsDto;
import com.example.event_managment_service.Model.Participant;

import java.util.List;
import java.util.Map;

public interface ResultsOfEventsService {

    ResultofEventsDto closeEventAndSumarizeWinner(Integer id);

    ResultofEventsDto getScoresByEvent(Integer id);
}
