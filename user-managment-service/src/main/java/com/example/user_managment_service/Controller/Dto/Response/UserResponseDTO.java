package com.example.user_managment_service.Controller.Dto.Response;


import com.example.user_managment_service.Model.Role;
import lombok.*;
import jakarta.persistence.*;


import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserResponseDTO {


    private Long id;
    private String username;
    private String email;


    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
