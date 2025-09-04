package com.example.user_managment_service.Service;

import com.example.user_managment_service.Controller.Dto.Request.UserCreateRequestDto;
import com.example.user_managment_service.Controller.Dto.Response.AllUsersWithRolesDTO;
import com.example.user_managment_service.Controller.Dto.Response.UserResponseDTO;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
    UserResponseDTO createNewUser(UserCreateRequestDto userCreateRequestDto);

    List<AllUsersWithRolesDTO> getAllUsersWithRoles();

    //ResponseEntity<?> createRole();
    //ResponseEntity<?> getAllRoles();
    //ResponseEntity<?> updateUserData();
    //ResponseEntity<?> deleteUserData();
    //ResponseEntity<?> changeUserRole();
    //ResponseEntity<?> activeUser();

    //ResponseEntity<?> LOGIN();
    //ResponseEntity<?> lOGOUT();


}
