package com.example.user_managment_service.Dto.mapper;

import com.example.user_managment_service.Controller.Dto.Request.UserCreateRequestDto;
import com.example.user_managment_service.Controller.Dto.Response.*;
import com.example.user_managment_service.Model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO userToResponseDTO(User user);
    User userCreateToResponseDTO(UserCreateRequestDto user);


    @Mapping(target = "roleResponseDTO", source = "roles") // MapStruct consegue mapear Set<Role> → Set<RoleResponseDTO> se existir o mapper
    AllUsersWithRolesDTO userToAllUsersWithRolesDTO(User user);

}
