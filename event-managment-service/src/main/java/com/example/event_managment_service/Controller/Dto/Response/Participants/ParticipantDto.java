package com.example.event_managment_service.Controller.Dto.Response.Participants;

public record ParticipantDto(
        Integer id_participant,
        String participant_name,
        Integer points
) {
}
