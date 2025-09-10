package com.example.event_managment_service.Service.ServiceImp;

import com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes.RouteDto;
import com.example.event_managment_service.Controller.Dto.Response.Event.EventDto;
import com.example.event_managment_service.Controller.Dto.Response.Participants.ParticipantDto;
import com.example.event_managment_service.Controller.Dto.Response.Score.ScoreResponseIdsAndNamesDto;
import com.example.event_managment_service.Model.Score;
import com.example.event_managment_service.Service.ScoresService;
import com.example.event_managment_service.mapper.ScoreMapper;
import com.example.event_managment_service.repository.ScoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScoresServiceImpl implements ScoresService {
    private final ScoresRepository scoresRepository;
    private final ScoreMapper scoreMapper;

    public ScoresServiceImpl(ScoresRepository scoresRepository, ScoreMapper scoreMapper) {
        this.scoresRepository = scoresRepository;
        this.scoreMapper = scoreMapper;
    }

 // public List<ScoreResponseIdsAndNamesDto> getAllScores() {
 //     List<ScoreResponseIdsAndNamesDto> scoreResponseDtoList = scoresRepository.findAll()
 //             .stream()
 //             .map(scoreMapper::entityToResponseDto)
 //             .toList();

 //     return scoreResponseDtoList;
 // }

    public Map<String, Map<String, List<ScoreResponseIdsAndNamesDto>>> getAllScoresGrouped() {
        List<ScoreResponseIdsAndNamesDto> scoreResponseDtoList = scoresRepository.findAll()
                .stream().map(scoreMapper::entityToResponseDto)
                .toList();

        return scoreResponseDtoList.stream()
                .collect(Collectors.groupingBy(
                        ScoreResponseIdsAndNamesDto::getEvent_name, // agrupa por evento
                        Collectors.groupingBy(ScoreResponseIdsAndNamesDto::getRoute_name) // agrupa por participante
                ));
    }

    public Map<String, Map<String, List<ScoreResponseIdsAndNamesDto>>> getAllScoresForeEventId(Integer id) {
        List<ScoreResponseIdsAndNamesDto> scoreResponseDtoList = scoresRepository.findByEvent_Id(id)
                .stream().map(scoreMapper::entityToResponseDto)
                .toList();

        return scoreResponseDtoList.stream()
                .collect(Collectors.groupingBy(
                        ScoreResponseIdsAndNamesDto::getEvent_name, // agrupa por evento
                        Collectors.groupingBy(ScoreResponseIdsAndNamesDto::getRoute_name) // agrupa por participante
                ));
    }

    public List<EventDto> getScoresGrouped(Integer id) {
        List<Score> scores = scoresRepository.findByEvent_Id(id);

        Map<String, Map<String, List<Score>>> grouped =
                scores.stream().collect(Collectors.groupingBy(
                        s -> s.getEvent().getName(),                 // agrupa por evento
                        Collectors.groupingBy(s -> s.getRoute().getName()) // agrupa por rota
                ));


        return grouped.entrySet().stream()
                .map(eventEntry -> new EventDto(
                        eventEntry.getKey(), // event_name
                        eventEntry.getValue().entrySet().stream()
                                .map(routeEntry -> new RouteDto(
                                        routeEntry.getKey(), // route_name
                                        routeEntry.getValue().stream()
                                                .map(s -> new ParticipantDto(
                                                        s.getParticipant().getParticipantId(),
                                                        s.getParticipant().getName(),
                                                        s.getPoints()
                                                ))
                                                .toList()
                                ))
                                .toList()
                ))
                .toList();
    }
}
