package com.example.event_managment_service.mapper;

import com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes.ClimbingRouteResponseDto;
import com.example.event_managment_service.Model.ClimbingRoute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" ,uses = {CategoryMapper.class})
public interface ClimbingRoutesMapper {
    @Mapping(target = "categoryResponseDto", source = "category")
    ClimbingRouteResponseDto entityToResponseDto(ClimbingRoute climbingRoute);
}
