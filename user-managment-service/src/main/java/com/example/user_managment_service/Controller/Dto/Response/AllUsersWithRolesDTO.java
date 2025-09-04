package com.example.user_managment_service.Controller.Dto.Response;

import com.example.user_managment_service.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AllUsersWithRolesDTO {
    private Long id;
    private String username;
    private String email;
    private Set<RoleResponseDTO> roleResponseDTO;
}
