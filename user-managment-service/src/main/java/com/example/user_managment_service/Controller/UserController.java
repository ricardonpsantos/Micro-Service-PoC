package com.example.user_managment_service.Controller;

import com.example.user_managment_service.Controller.Dto.Request.UserCreateRequestDto;
import com.example.user_managment_service.Controller.Dto.Response.AllUsersWithRolesDTO;
import com.example.user_managment_service.Controller.Dto.Response.UserResponseDTO;
import com.example.user_managment_service.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        UserResponseDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/new")
    public ResponseEntity<UserResponseDTO> createNewUser(@Valid @RequestBody UserCreateRequestDto userCreateRequestDto) {
        return new ResponseEntity<>(userService.createNewUser(userCreateRequestDto),HttpStatus.CREATED);
    }

    @GetMapping("/allwithroles")
    public ResponseEntity<List<AllUsersWithRolesDTO>> getAllUsersWithRoles(){
        return new ResponseEntity<>(userService.getAllUsersWithRoles(),HttpStatus.OK);
    }

}
