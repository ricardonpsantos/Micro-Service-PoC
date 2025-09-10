package com.example.event_managment_service.mapper;

import com.example.event_managment_service.Controller.Dto.Request.Category.CategoryRequestDto;
import com.example.event_managment_service.Controller.Dto.Response.Category.CategoryResponseDto;
import com.example.event_managment_service.Model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDto categoryEntityToResponseDTO (Category category);
    Category categoryRequestToEntity (CategoryRequestDto categoryRequestDto);
}

