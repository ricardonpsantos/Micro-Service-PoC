package com.example.user_managment_service.Service;

import com.example.user_managment_service.Controller.Dto.Request.RoleRequestDTO;
import com.example.user_managment_service.Controller.Dto.Response.RoleResponseDTO;

import java.util.List;

public interface RoleService {
    List<RoleResponseDTO> getAllRoles();

    RoleResponseDTO addNewRole(RoleRequestDTO roleRequestDTO);

}
