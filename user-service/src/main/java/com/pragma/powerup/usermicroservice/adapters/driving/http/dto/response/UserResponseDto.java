package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
public class UserResponseDto {
    private String name;
    private String surname;
    private String dniNumber;
    private String phone;
    private LocalDate birthdate;
    private String mail;
    private String password;
    private Long idRole;
}
