package com.example.user_managment_service.Service.ServiceImp;

import com.example.user_managment_service.Controller.Dto.Request.RoleRequestDTO;
import com.example.user_managment_service.Controller.Dto.Response.RoleResponseDTO;
import com.example.user_managment_service.Dto.mapper.RoleMapper;
import com.example.user_managment_service.Dto.mapper.UserMapper;
import com.example.user_managment_service.Exception.InvalidDataException;
import com.example.user_managment_service.Exception.NotFoundException;
import com.example.user_managment_service.Model.Role;
import com.example.user_managment_service.Service.RoleService;
import com.example.user_managment_service.repository.RoleRepository;
import com.example.user_managment_service.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleResponseDTO> getAllRoles() {

        final var listAllRoles = roleRepository.findAll()
                .stream()
                .map(roleMapper::roleEntityToResponseDTO)
                .toList();

        if (listAllRoles.isEmpty()) {
            throw new NotFoundException("Roles Not Defined");
        }
        return listAllRoles;
    }

    public RoleResponseDTO addNewRole(RoleRequestDTO roleRequestDTO) {

        roleRepository.findByName(roleRequestDTO.getName())
                .ifPresent(r -> {
                    throw new InvalidDataException("Role already exists: " + roleRequestDTO.getName());
                });

        Role role = roleRepository.save(roleMapper.dtoToRoleEntity(roleRequestDTO));
        return roleMapper.roleEntityToResponseDTO(role);
    }
}
