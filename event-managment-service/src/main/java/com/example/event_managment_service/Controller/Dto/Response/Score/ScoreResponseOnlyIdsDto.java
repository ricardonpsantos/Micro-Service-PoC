package com.example.event_managment_service.Controller.Dto.Response.Score;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record ScoreResponseOnlyIdsDto(
        Integer idScore,
        Integer idEvent,
        String eventName,
        Integer idParticipant,
        String participantName,
        String routeName,
        Integer idRoute,
        Integer points) {
}
