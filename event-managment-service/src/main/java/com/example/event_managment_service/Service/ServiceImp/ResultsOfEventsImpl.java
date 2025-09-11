package com.example.event_managment_service.Service.ServiceImp;

import com.example.event_managment_service.Controller.Dto.Response.Participants.ParticipantDto;
import com.example.event_managment_service.Controller.Dto.Response.ResultOfEvents.ResultofEventsDto;
import com.example.event_managment_service.Exception.NotFoundException;
import com.example.event_managment_service.Model.*;
import com.example.event_managment_service.Service.ResultsOfEventsService;
import com.example.event_managment_service.mapper.ParticipantsMapper;
import com.example.event_managment_service.repository.EventRepository;
import com.example.event_managment_service.repository.ResultOfEventsRepository;
import com.example.event_managment_service.repository.ScoresRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResultsOfEventsImpl implements ResultsOfEventsService {

    private final EventRepository eventRepository;
    private final ScoresRepository scoresRepository;
    private final ResultOfEventsRepository resultOfEventsRepository;
    private final ParticipantsMapper participantsMapper;

    public ResultsOfEventsImpl(EventRepository eventRepository, ScoresRepository scoresRepository, ResultOfEventsRepository resultOfEventsRepository, ParticipantsMapper participantsMapper) {
        this.eventRepository = eventRepository;
        this.scoresRepository = scoresRepository;
        this.resultOfEventsRepository = resultOfEventsRepository;
        this.participantsMapper = participantsMapper;
    }


    public ResultofEventsDto closeEventAndSumarizeWinner(Integer id) {

        Event event = eventRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new NotFoundException("Event Not Exist"));

        List<Score> scores = scoresRepository.findByEvent_IdEvent(id);

        Map<Participant, Integer> totalPointsByParticipant = scores.stream()
                .collect(Collectors.groupingBy(
                        Score::getParticipant,
                        Collectors.summingInt(Score::getPoints)
                ));

        List<ParticipantDto> listParticipantDto = new ArrayList<>();

        totalPointsByParticipant.forEach((participant, points) -> {
            resultOfEventsRepository.save(new ResultsOfEvents(participant, event, points));
            listParticipantDto.add(new ParticipantDto(participant.getParticipantId(), participant.getName(), points));
        });

        event.setEventStatus(EventStatus.COMPLETED);
        eventRepository.save(event);

        return new ResultofEventsDto(event.getEventName(),event.getEventStatus().name(), listParticipantDto
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));
    }

    public ResultofEventsDto getScoresByEvent(Integer id) {

        Event event = eventRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new NotFoundException("Event Not Exist"));

        List<Score> scores = scoresRepository.findByEvent_IdEvent(id);


        Map<Participant, Integer> totalPointsByParticipant = scores.stream()
                .collect(Collectors.groupingBy(
                        Score::getParticipant,
                        Collectors.summingInt(Score::getPoints)
                ));
        List<ParticipantDto> listParticipantDto = new ArrayList<>();

        totalPointsByParticipant.forEach((participant, points) -> {
            resultOfEventsRepository.save(new ResultsOfEvents(participant, event, points));
            listParticipantDto.add(new ParticipantDto(participant.getParticipantId(), participant.getName(), points));
        });

        return new ResultofEventsDto(event.getEventName(),event.getEventStatus().name(), listParticipantDto
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));
    }
}