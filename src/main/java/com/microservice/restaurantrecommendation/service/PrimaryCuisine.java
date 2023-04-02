package com.microservice.restaurantrecommendation.service;

import com.microservice.restaurantrecommendation.model.Cuisine;
import com.microservice.restaurantrecommendation.model.User;

public class PrimaryCuisine implements CuisineTypeService{

    @Override
    public Cuisine extractCuisineFromUser(User user) {
        return user.getCuisines().size() > 0 ? user.getCuisines().get(0).getType() : null;
    }
}
