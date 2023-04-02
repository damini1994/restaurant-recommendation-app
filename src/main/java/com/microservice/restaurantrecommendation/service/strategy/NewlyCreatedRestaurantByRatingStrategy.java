package com.microservice.restaurantrecommendation.service.strategy;

import com.microservice.restaurantrecommendation.model.CuisineAndCostBracketCategory;
import com.microservice.restaurantrecommendation.model.Restaurant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NewlyCreatedRestaurantByRatingStrategy implements RestaurantSortingStrategy{
    private CuisineAndCostBracketCategory category;

    public NewlyCreatedRestaurantByRatingStrategy(CuisineAndCostBracketCategory category) {
        this.category = category;
    }

    @Override
    public List<Restaurant> sortRestaurants(List<Restaurant> availableRestaurants, int restaurantLimit, int sortedRestaurantSize) {

        availableRestaurants.sort(Comparator.comparing(Restaurant::getRating).reversed());

        List<Restaurant> result = new ArrayList<>();
        int count = 4;
        for (Restaurant restaurant : availableRestaurants) {
                result.add(restaurant);
                count--;
                sortedRestaurantSize++;

            if(result.size() == restaurantLimit || count == 0 || sortedRestaurantSize > availableRestaurants.size())
                break;
        }
        return result;
    }
}
