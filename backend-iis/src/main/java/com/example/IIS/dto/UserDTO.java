package com.example.IIS.dto;

import com.example.IIS.domain.Role;
import com.example.IIS.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String image;
    private Gender gender;
}
