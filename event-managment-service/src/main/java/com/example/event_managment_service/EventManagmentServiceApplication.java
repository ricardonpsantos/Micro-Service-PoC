package com.example.event_managment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.amqp.RabbitHealthContributorAutoConfiguration.class
})
@EnableFeignClients(basePackages = "com/example/event_managment_service/Integration")
public class EventManagmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagmentServiceApplication.class, args);
	}




}
