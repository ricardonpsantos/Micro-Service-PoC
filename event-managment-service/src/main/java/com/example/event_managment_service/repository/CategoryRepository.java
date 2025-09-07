package com.example.event_managment_service.repository;

import com.example.event_managment_service.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    boolean existsByCategoryName(String categoryName);
}
