package com.example.event_managment_service.Controller.Dto.Response.Participants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParticipantsResponseDto {
    private Integer participant_id;
    private String name;
    private String email;
    private String address;
    private String identification_id;
}
