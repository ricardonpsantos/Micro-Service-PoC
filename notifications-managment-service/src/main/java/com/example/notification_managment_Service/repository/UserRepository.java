package com.example.notification_managment_Service.repository;


import com.example.notification_managment_Service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
