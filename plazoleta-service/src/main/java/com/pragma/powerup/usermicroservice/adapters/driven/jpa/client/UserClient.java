package com.pragma.powerup.usermicroservice.adapters.driven.jpa.client;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.client.feignModels.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8091/user")
public interface UserClient {
    @GetMapping(value = "/owner/{id}")
    User getOwner(@PathVariable("id") Long id);
}