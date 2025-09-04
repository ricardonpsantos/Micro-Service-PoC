package com.example.user_managment_service.Controller;

import com.example.user_managment_service.Controller.Dto.Request.UserCreateRequestDto;
import com.example.user_managment_service.Controller.Dto.Response.AllUsersWithRolesDTO;
import com.example.user_managment_service.Controller.Dto.Response.UserResponseDTO;
import com.example.user_managment_service.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Lista todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @Operation(summary = "Procura um user por ID")
    @GetMapping("/byid/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        UserResponseDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Cria um novo User")
    @PostMapping("/new")
    public ResponseEntity<UserResponseDTO> createNewUser(@Valid @RequestBody UserCreateRequestDto userCreateRequestDto) {
        return new ResponseEntity<>(userService.createNewUser(userCreateRequestDto),HttpStatus.CREATED);
    }

    @Operation(summary = "Procura todos os users com os respectivos Roles")
    @GetMapping("/allwithroles")
    public ResponseEntity<List<AllUsersWithRolesDTO>> getAllUsersWithRoles(){
        return new ResponseEntity<>(userService.getAllUsersWithRoles(),HttpStatus.OK);
    }


}
