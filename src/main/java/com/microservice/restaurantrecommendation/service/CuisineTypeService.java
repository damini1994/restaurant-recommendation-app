package com.microservice.restaurantrecommendation.service;

import com.microservice.restaurantrecommendation.model.Cuisine;
import com.microservice.restaurantrecommendation.model.User;

public interface CuisineTypeService {

    Cuisine extractCuisineFromUser(User user);
}
