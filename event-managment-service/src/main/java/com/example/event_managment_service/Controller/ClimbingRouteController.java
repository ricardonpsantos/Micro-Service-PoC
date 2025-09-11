package com.example.event_managment_service.Controller;

import com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes.ClimbingRouteResponseDto;
import com.example.event_managment_service.Service.ClimbingRouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/climbing-routes")
public class ClimbingRouteController {
    private final ClimbingRouteService climbingRouteService;

    public ClimbingRouteController(ClimbingRouteService climbingRouteService) {
        this.climbingRouteService = climbingRouteService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<ClimbingRouteResponseDto> getAllClimbingRoutes() {
        return climbingRouteService.getAllClimbingRoutes();
    }

}
