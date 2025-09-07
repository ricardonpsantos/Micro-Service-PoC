package com.example.event_managment_service.Service;

import com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes.ClimbingRouteResponseDto;

import java.util.List;

public interface ClimbingRouteService {
    List<ClimbingRouteResponseDto> getAllClimbingRoutes();
}
