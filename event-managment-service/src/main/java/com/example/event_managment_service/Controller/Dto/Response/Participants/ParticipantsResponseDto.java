package com.example.event_managment_service.Controller.Dto.Response.Participants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record ParticipantsResponseDto(
        Integer participant_id,
        String name,
        String email,
        String address,
        String identification_id) {
}
