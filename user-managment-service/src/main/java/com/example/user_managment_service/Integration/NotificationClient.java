/*package com.example.user_managment_service.Integration;

import com.example.user_managment_service.Dto.Notification.EmailRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:8082")
public interface NotificationClient {

    @PostMapping("/notifications/send/micro/service")
    String sendNotification(@RequestBody EmailRequestDto emailRequestDto);
}




 */