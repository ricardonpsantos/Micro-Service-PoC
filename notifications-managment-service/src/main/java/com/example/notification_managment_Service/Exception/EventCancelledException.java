package com.example.notification_managment_Service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class EventCancelledException extends RuntimeException {
    public EventCancelledException(String name) {
        super(name);
    }
}
