package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class PersonRequestDto {
    @NotBlank(message = "Field 'name' it's required")
    private String name;

    @NotBlank(message = "Field 'surname' it's required")
    private String surname;

    private LocalDate birthdate;

    @NotBlank(message = "Field 'email' it's required")
    @Email(message = "Field 'email' must be a valid email direction. Enter the format name@example.com")
    private String mail;

    @Pattern(regexp = "^\\+?57\\s(3[0-2]|7[0-1])\\d{8}$", message = "Field 'numberPhone' must be a valid number phone. Enter the format +57 3...")
    @NotBlank(message = "Field 'phoneNumber' it's required")
    private String phone;

    @NotBlank(message = "Field 'address' it's required")
    private String address;

    @NotBlank(message = "Field 'idDniType' it's required")
    private String idDniType;

    @Pattern(regexp = "^[0-9]*$", message = "Field 'identificationNumber' must be only numbers")
    @NotBlank(message = "Field 'identificationNumber' it's required")
    private String dniNumber;

    @NotBlank(message = "Field 'idPersonType' it's required")
    private String idPersonType;

    @NotBlank(message = "Field 'password' it's required")
    private String password;

}
