package com.example.event_managment_service.Controller.Dto.Request.Event;

import jakarta.validation.constraints.NotNull;

public record AddRouteRequestDto(
        @NotNull(message = "idEvent must be Fill")
        Integer idEvent,
        @NotNull(message = "idRoutes must be Fill")
        Integer idRoutes) {
}
