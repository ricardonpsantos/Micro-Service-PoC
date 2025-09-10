package com.example.event_managment_service.Controller.Dto.Response.Participants;

import org.jetbrains.annotations.NotNull;

public record ParticipantDto(
        Integer id_participant,
        String participant_name,
        Integer points
) implements Comparable<ParticipantDto> {

    @Override
    public int compareTo(@NotNull ParticipantDto other) {
        return this.points.compareTo(other.points);
    }
}
