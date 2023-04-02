package com.microservice.restaurantrecommendation.service;

import com.microservice.restaurantrecommendation.model.Cuisine;
import com.microservice.restaurantrecommendation.model.User;

public class SecondaryCuisine1 implements CuisineTypeService{
    @Override
    public Cuisine extractCuisineFromUser(User user) {
        return user.getCuisines().size() > 1 ? user.getCuisines().get(1).getType() : null;
    }
}
