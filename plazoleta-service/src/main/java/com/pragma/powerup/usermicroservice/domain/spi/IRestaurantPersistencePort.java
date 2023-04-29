package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.powerup.usermicroservice.domain.model.RestaurantModel;

public interface IRestaurantPersistencePort {
    RestaurantEntity saveRestaurant(RestaurantModel restaurantModel);
}
