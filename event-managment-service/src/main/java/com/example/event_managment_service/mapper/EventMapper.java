package com.example.event_managment_service.mapper;

import com.example.event_managment_service.Controller.Dto.Request.Event.EventRequestDTO;
import com.example.event_managment_service.Controller.Dto.Response.Event.EventResponseDTO;
import com.example.event_managment_service.Model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClimbingRoutesMapper.class})
public interface EventMapper {

    @Mapping(target = "climbingRouteResponseDtos", source = "routes")
    EventResponseDTO entityToResponseDto(Event event);

    Event requestToentityDto(EventRequestDTO eventRequestDTO);
}
