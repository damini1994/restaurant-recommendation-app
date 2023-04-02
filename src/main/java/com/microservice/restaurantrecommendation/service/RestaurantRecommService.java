package com.microservice.restaurantrecommendation.service;

import com.microservice.restaurantrecommendation.model.Restaurant;
import com.microservice.restaurantrecommendation.model.User;

import java.util.List;

public interface RestaurantRecommService {

    List<String> getRestaurantRecommendations(User user, List<Restaurant> availableRestaurants);
}
