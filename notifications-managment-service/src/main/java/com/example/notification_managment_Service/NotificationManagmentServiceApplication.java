package com.example.notification_managment_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com/example/notification_managment_Service/Integration")
public class NotificationManagmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationManagmentServiceApplication.class, args);
	}

}
