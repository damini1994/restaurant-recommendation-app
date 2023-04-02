package com.microservice.restaurantrecommendation.service;

import com.microservice.restaurantrecommendation.model.Cuisine;
import com.microservice.restaurantrecommendation.model.User;

public class SecondaryCuisine2 implements CuisineTypeService{
    @Override
    public Cuisine extractCuisineFromUser(User user) {
        return user.getCuisines().size() > 2 ? user.getCuisines().get(2).getType() : null;
    }
}
