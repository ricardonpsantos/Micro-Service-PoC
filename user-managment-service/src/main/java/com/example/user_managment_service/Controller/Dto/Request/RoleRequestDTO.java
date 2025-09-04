package com.example.user_managment_service.Controller.Dto.Request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequestDTO {


    @NotBlank(message = "Username is mandatory")
    @NotNull(message = "Username is mandatory")
    @Size(min = 3, max = 50,message = "size more than 3")
    private String name;

    @NotBlank(message = "Username is mandatory")
    @NotNull(message = "Username is mandatory")
    @Size(min = 3, max = 50,message = "size more than 3")
    private String description;

}
