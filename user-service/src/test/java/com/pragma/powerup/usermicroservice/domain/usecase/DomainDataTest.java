package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DomainDataTest {
    public static User obtainUser(){
        return new User(
                1L,
                "Halbert",
                "Jese",
                "6454654",
                "+57 3134647582",
                LocalDate.of(2000, 02, 24),
                "jese@gmail.com",
                "Jese",
                new Role(
                        1L,
                        "ADMIN",
                        "ADMIN"
                )
        );
    }

    public static List<Role> obtainRoles() {
        List<Role> roleList = new ArrayList<>();

        roleList.add(new Role(1L,
                "ADMIN",
                "ADMIN"));
        roleList.add(new Role(2L,
                "OWNER",
                "OWNER"));

        return roleList;
    }

}
