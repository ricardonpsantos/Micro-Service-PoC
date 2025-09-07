package com.example.event_managment_service.Controller.Dto.Request.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequestDto {

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 50, message = "Category name must be between 3 and 50 characters")
    private String categoryName;
}
