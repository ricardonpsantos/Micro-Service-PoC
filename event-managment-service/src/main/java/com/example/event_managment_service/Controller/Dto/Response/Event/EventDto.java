package com.example.event_managment_service.Controller.Dto.Response.Event;

import com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes.RouteDto;

import java.util.List;

public record EventDto(
        String event_name,
        List<RouteDto> routes
) {}
