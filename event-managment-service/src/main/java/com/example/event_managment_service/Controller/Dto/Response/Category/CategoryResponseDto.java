package com.example.event_managment_service.Controller.Dto.Response.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryResponseDto {
    private Integer categoryId;
    private String categoryName;
}
