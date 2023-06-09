package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IRestaurantRequestMapper;
import com.pragma.powerup.usermicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.usermicroservice.domain.model.RestaurantModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RestaurantHandlerTest {

    @InjectMocks
    private RestaurantHandler restaurantHandler;
    @Mock
    IRestaurantServicePort restaurantServicePort;
    @Mock
    IRestaurantRequestMapper restaurantRequestMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveRestaurant() {
        RestaurantModel restaurantModel = HttpDataTest.obtainRestaurant();
        RestaurantRequestDto restaurantRequest = HttpDataTest.obtainRestaurantRequest();

        when(restaurantRequestMapper.toRestaurantRequest(restaurantRequest)).thenReturn(restaurantModel);
        restaurantHandler.saveRestaurant(restaurantRequest);

        verify(restaurantServicePort).saveRestaurant(restaurantModel);
    }
}