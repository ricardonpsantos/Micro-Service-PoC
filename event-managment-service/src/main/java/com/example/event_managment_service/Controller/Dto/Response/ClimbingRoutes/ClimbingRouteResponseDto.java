package com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes;

import com.example.event_managment_service.Controller.Dto.Response.Category.CategoryResponseDto;
import com.example.event_managment_service.Model.Category;
import com.example.event_managment_service.Model.DifficultyLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record ClimbingRouteResponseDto(Integer id,
                                       String name,
                                       CategoryResponseDto categoryResponseDto,
                                       DifficultyLevel difficultyLevel,
                                       Integer routeHeight) {
}
