package com.pragma.powerup.usermicroservice.domain.validations;

import com.pragma.powerup.usermicroservice.domain.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class PersonValid {

    public static boolean heIsOlder(Person person) {
        String fechaNacimiento = String.valueOf(person.getBirthdate());
        try {
            LocalDate fecha = LocalDate.parse(fechaNacimiento);
            LocalDate ahora = LocalDate.now();
            Period periodo = Period.between(fecha, ahora);
            int edad = periodo.getYears();
            return edad >= 18;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
