package com.example.event_managment_service.Controller.Dto.Response.Event;

import com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes.ClimbingRouteResponseDto;
import com.example.event_managment_service.Model.ClimbingRoute;
import com.example.event_managment_service.Model.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventResponseDTO {

    private Integer id;
    private String name;
    private String description;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private String location;
    private EventStatus status;
    private Set<ClimbingRouteResponseDto> climbingRouteResponseDtos;
}
