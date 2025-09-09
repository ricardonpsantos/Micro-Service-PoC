package com.example.event_managment_service.Controller.Dto.Request.Event;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddRouteRequestDto {

    @NotNull(message = "idEvent must be Fill")
    private Integer idEvent;
    @NotNull(message = "idRoutes must be Fill")
    private Integer idRoutes;

}
