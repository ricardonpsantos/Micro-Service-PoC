package com.example.event_managment_service.Controller.Dto.Request.Event;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record RemoveRouteRequestDto(
        @NotNull(message = "idEvent must be Fill")
        Integer idEvent,
        @NotNull(message = "idRoutes must be Fill")
        Integer idRoutes) {
}
