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


public record EventResponseDTO(Integer idEvent,
                               String eventName,
                               String eventDescription,
                               LocalDateTime startDate,
                               LocalDateTime endDate,
                               String eventLocation,
                               EventStatus eventStatus,
                               Set<ClimbingRouteResponseDto> climbingRouteResponseDtos) {
}
