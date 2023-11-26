package com.Electronic.Store.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Userdtos {


    private String id;

    @Size(min = 3,max = 15)
    private String Name;


    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "invalid email")
    private String email;

    @NotBlank(message = "write the password ")
    private String password;

    @Size(min = 4,max = 6)
    private String gender;

    @NotBlank(message = "invalid image name")
    private String imageName;

}
