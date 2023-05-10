package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.client.UserClient;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.RestaurantJpaAdapter;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IRestaurantEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.usermicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.usermicroservice.domain.ports.IRestaurantPersistencePort;
import com.pragma.powerup.usermicroservice.domain.usecase.RestaurantUseCase;
import feign.RequestInterceptor;
import jakarta.ws.rs.core.HttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    // Restaurant
    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort(IRestaurantRepository restaurantRepository, IRestaurantEntityMapper restaurantEntityMapper) {
        return new RestaurantJpaAdapter(restaurantRepository, restaurantEntityMapper);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort(IRestaurantPersistencePort restaurantPersistencePort, UserClient userClient){
        return new RestaurantUseCase(restaurantPersistencePort, userClient);
    }

    @Bean
    public RequestInterceptor requestInterceptor() {

        return requestTemplate -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
                requestTemplate.header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", details.getTokenValue()));
            }
        };
    }

}
