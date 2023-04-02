package com.microservice.restaurantrecommendation.service.strategy;

import com.microservice.restaurantrecommendation.model.Restaurant;
import com.microservice.restaurantrecommendation.model.User;

import java.util.List;

public interface RestaurantSortingStrategy {

    List<Restaurant> sortRestaurants(List<Restaurant> availableRestaurants, int restaurantLimit, int sortedRestaurantSize);
}
