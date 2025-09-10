package com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes;

import com.example.event_managment_service.Controller.Dto.Response.Participants.ParticipantDto;

import java.util.List;

public record RouteDto(
        String route_name,
        List<ParticipantDto> participants
) {}
