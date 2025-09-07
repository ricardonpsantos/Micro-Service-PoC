package com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes;

import com.example.event_managment_service.Controller.Dto.Response.Category.CategoryResponseDto;
import com.example.event_managment_service.Model.Category;
import com.example.event_managment_service.Model.DifficultyLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClimbingRouteResponseDto {
    private Integer id;
    private String name;
    private CategoryResponseDto categoryResponseDto;
    private DifficultyLevel difficultyLevel;
    private Integer routeHeight;
}
