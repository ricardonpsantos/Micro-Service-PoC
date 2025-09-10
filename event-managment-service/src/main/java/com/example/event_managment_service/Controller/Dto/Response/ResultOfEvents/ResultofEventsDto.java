package com.example.event_managment_service.Controller.Dto.Response.ResultOfEvents;

import com.example.event_managment_service.Controller.Dto.Response.Participants.ParticipantDto;

import java.util.List;

public record ResultofEventsDto(
        String eventNamE,
        String statusEvent,
        List<ParticipantDto> participantDto
) {
}
