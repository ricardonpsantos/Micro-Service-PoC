package com.example.user_managment_service.Dto.mapper;

import com.example.user_managment_service.Controller.Dto.Request.RoleRequestDTO;
import com.example.user_managment_service.Controller.Dto.Response.RoleResponseDTO;
import com.example.user_managment_service.Model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponseDTO roleEntityToResponseDTO (Role role);
    Role dtoToRoleEntity (RoleRequestDTO roleRequestDTO);

}
