package com.example.user_managment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com/example/user_managment_service/Integration")
public class UserManagmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagmentServiceApplication.class, args);
	}

}
