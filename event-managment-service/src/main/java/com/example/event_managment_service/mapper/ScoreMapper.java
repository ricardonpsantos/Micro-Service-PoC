package com.example.event_managment_service.mapper;


import com.example.event_managment_service.Controller.Dto.Response.Score.ScoreResponseOnlyIdsDto;
import com.example.event_managment_service.Model.Score;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {Score.class})
public interface ScoreMapper {

    @Mapping(target = "idScore", source = "idScore")
    @Mapping(target = "idEvent", source = "event.id")
    @Mapping(target = "idParticipant", source = "participant.participantId")
    @Mapping(target = "idRoute", source = "route.id")
    @Mapping(target = "points", source = "points")
    @Mapping(target = "eventName", source = "event.name")
    @Mapping(target = "participantName", source = "participant.name")
    @Mapping(target = "routeName", source = "route.name")
    ScoreResponseOnlyIdsDto entityToResponseDto(Score score);

}
