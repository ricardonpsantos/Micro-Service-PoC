package com.example.user_managment_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.user_managment_service.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
