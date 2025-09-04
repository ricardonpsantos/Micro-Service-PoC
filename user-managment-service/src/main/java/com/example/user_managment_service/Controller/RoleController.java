package com.example.user_managment_service.Controller;

import com.example.user_managment_service.Controller.Dto.Request.RoleRequestDTO;
import com.example.user_managment_service.Controller.Dto.Response.RoleResponseDTO;
import com.example.user_managment_service.Controller.Dto.Response.UserResponseDTO;
import com.example.user_managment_service.Service.RoleService;
import com.example.user_managment_service.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @PostMapping("/addnew")
    public ResponseEntity<RoleResponseDTO> addNewRole(@Valid @RequestBody RoleRequestDTO roleRequestDTO) {
        return new ResponseEntity<>(roleService.addNewRole(roleRequestDTO),HttpStatus.CREATED);
    }
}
