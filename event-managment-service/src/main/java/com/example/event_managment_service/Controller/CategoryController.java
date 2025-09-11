package com.example.event_managment_service.Controller;

import com.example.event_managment_service.Controller.Dto.Request.Category.CategoryRequestDto;
import com.example.event_managment_service.Controller.Dto.Response.Category.CategoryResponseDto;
import com.example.event_managment_service.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    public CategoryResponseDto createCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.createCategory(categoryRequestDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CategoryResponseDto  getCategoryById(@Valid @RequestParam Integer id) {
        return categoryService.getCategoryById(id);
    }
}
