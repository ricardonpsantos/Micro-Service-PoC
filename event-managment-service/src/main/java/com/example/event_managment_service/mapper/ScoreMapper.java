package com.example.event_managment_service.mapper;


import com.example.event_managment_service.Controller.Dto.Response.Score.ScoreResponseIdsAndNamesDto;
import com.example.event_managment_service.Model.Score;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" ,uses = {Score.class})
public interface ScoreMapper {

    @Mapping(target = "id_score", source = "id_score")
    @Mapping(target = "id_event", source = "event.id")
    @Mapping(target = "id_participant", source = "participant.participantId")
    @Mapping(target = "id_route", source = "route.id")
    @Mapping(target = "points", source = "points")
    @Mapping(target = "event_name", source = "event.name")
    @Mapping(target = "participant_name", source = "participant.name")
    @Mapping(target = "route_name", source = "route.name")
    ScoreResponseIdsAndNamesDto entityToResponseDto(Score score);

}
