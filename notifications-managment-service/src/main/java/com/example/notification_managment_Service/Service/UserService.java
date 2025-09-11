package com.example.notification_managment_Service.Service;

import com.example.notification_managment_Service.Model.User;

import java.util.List;

public interface UserService {
    String returnName (String name);
    List<User> getAllUsers();
}
