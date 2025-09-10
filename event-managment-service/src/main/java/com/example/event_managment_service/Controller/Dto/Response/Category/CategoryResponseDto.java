package com.example.event_managment_service.Controller.Dto.Response.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record CategoryResponseDto(Integer categoryId,
                                  String categoryName) {
}
