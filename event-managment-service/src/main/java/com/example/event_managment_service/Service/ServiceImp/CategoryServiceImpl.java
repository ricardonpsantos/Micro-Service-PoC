package com.example.event_managment_service.Service.ServiceImp;

import com.example.event_managment_service.Controller.Dto.Request.Category.CategoryRequestDto;
import com.example.event_managment_service.Controller.Dto.Response.Category.CategoryResponseDto;
import com.example.event_managment_service.Exception.AlreadyExistException;
import com.example.event_managment_service.Exception.NotFoundException;
import com.example.event_managment_service.Service.CategoryService;
import com.example.event_managment_service.mapper.CategoryMapper;
import com.example.event_managment_service.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponseDto> getAllCategories() {
        List<CategoryResponseDto> allCategories = categoryRepository.findAll()
                .stream()
                .filter(s -> !s.getCategoryName().isBlank())
                .map(categoryMapper::categoryEntityToResponseDTO)
                .toList();

        if (allCategories.isEmpty()) {
            throw new NotFoundException("Categories not found");
        }

        return allCategories;
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {

        if (categoryRepository.existsByCategoryName(categoryRequestDto.getCategoryName())) {
            throw new AlreadyExistException("Category already exists: " + categoryRequestDto.getCategoryName());
        }
        return categoryMapper.categoryEntityToResponseDTO(
                categoryRepository.save(
                        categoryMapper.categoryRequestToEntity(categoryRequestDto)
                )
        );
    }

    @Override
    public CategoryResponseDto getCategoryById(Integer id) {
        return categoryRepository.findById(Long.valueOf(id))
                .map(categoryMapper::categoryEntityToResponseDTO)
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + id));
    }
}
