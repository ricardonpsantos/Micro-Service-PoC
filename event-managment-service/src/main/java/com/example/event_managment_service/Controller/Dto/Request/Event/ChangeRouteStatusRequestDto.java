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
public class ChangeRouteStatusRequestDto {

    @NotNull(message = "idEvent must be Fill")
    private Integer idEvent;
    @NotNull(message = "idChange must be fill")
    private Integer idChange;
}
