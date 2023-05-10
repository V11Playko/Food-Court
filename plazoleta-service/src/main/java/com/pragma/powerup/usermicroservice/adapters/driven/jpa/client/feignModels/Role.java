package com.pragma.powerup.usermicroservice.adapters.driven.jpa.client.feignModels;

import lombok.Data;

@Data
public class Role {
    private Long id;
    private String name;
    private String description;
}
