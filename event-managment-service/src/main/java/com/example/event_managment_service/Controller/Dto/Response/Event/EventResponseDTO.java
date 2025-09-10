package com.example.event_managment_service.Controller.Dto.Response.Event;

import com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes.ClimbingRouteResponseDto;
import com.example.event_managment_service.Model.ClimbingRoute;
import com.example.event_managment_service.Model.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public record EventResponseDTO(Integer id,
                               String name,
                               String description,
                               LocalDateTime startDate,
                               LocalDateTime endDate,
                               String location,
                               EventStatus status,
                               Set<ClimbingRouteResponseDto> climbingRouteResponseDtos) {
}
