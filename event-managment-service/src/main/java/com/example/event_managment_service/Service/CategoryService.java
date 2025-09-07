package com.example.event_managment_service.Service;


import com.example.event_managment_service.Controller.Dto.Request.Category.CategoryRequestDto;
import com.example.event_managment_service.Controller.Dto.Response.Category.CategoryResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto createCategory(@Valid CategoryRequestDto categoryRequestDto);

    CategoryResponseDto getCategoryById(Integer id);
}
