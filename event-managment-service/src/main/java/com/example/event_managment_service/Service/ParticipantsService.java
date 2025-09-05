package com.example.event_managment_service.Service;

import com.example.event_managment_service.Controller.Dto.Response.ParticipantsResponseDto;

import java.util.List;

public interface ParticipantsService {
    List<ParticipantsResponseDto> getAllParticipants();
}
