package com.example.event_managment_service.mapper;

import com.example.event_managment_service.Controller.Dto.Response.ParticipantsResponseDto;
import com.example.event_managment_service.Model.Participant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParticipantsMapper {
    ParticipantsResponseDto roleEntityToResponseDTO (Participant role);
}
