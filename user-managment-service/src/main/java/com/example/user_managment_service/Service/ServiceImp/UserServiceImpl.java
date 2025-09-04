package com.example.user_managment_service.Service.ServiceImp;

import com.example.user_managment_service.Controller.Dto.Request.UserCreateRequestDto;
import com.example.user_managment_service.Controller.Dto.Response.AllUsersWithRolesDTO;
import com.example.user_managment_service.Controller.Dto.Response.UserResponseDTO;
import com.example.user_managment_service.Dto.mapper.UserMapper;
import com.example.user_managment_service.Exception.InvalidDataException;
import com.example.user_managment_service.Exception.NotFoundException;
import com.example.user_managment_service.Model.User;
import com.example.user_managment_service.Service.UserService;
import com.example.user_managment_service.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<UserResponseDTO> getAllUsers() {

        List<UserResponseDTO> listUsers =
                Optional.of(userRepository.findAll()
                                .stream()
                                .map(mapper::userToResponseDTO)
                                .toList())
                        .filter(list -> !list.isEmpty())
                        .orElseThrow(() -> new NotFoundException("No users found"));
        return listUsers;
    }

    public UserResponseDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(mapper::userToResponseDTO)
                .orElseThrow(() -> {
                    return new NotFoundException("User not found with id: " + id);
                });
    }

    public UserResponseDTO createNewUser(UserCreateRequestDto userCreateRequestDto) {
        User user = mapper.userCreateToResponseDTO(userCreateRequestDto);
        return mapper.userToResponseDTO(userRepository.save(user));
    }

    public List<AllUsersWithRolesDTO> getAllUsersWithRoles() {

        List<User> listAllUsers = userRepository.findAll();

        List<AllUsersWithRolesDTO> allUsersWithRolesDTOS = listAllUsers.stream()
                .map(mapper::userToAllUsersWithRolesDTO)
                .toList();

        return allUsersWithRolesDTOS;

    }
}
