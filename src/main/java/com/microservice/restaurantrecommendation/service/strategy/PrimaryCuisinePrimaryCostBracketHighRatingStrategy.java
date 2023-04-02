package com.microservice.restaurantrecommendation.service.strategy;

import com.microservice.restaurantrecommendation.model.CuisineAndCostBracketCategory;
import com.microservice.restaurantrecommendation.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class PrimaryCuisinePrimaryCostBracketHighRatingStrategy implements RestaurantSortingStrategy {

    private CuisineAndCostBracketCategory category;

    public PrimaryCuisinePrimaryCostBracketHighRatingStrategy(CuisineAndCostBracketCategory category) {
        this.category = category;
    }

    @Override
    public List<Restaurant> sortRestaurants(List<Restaurant> availableRestaurants, int restaurantLimit,int sortedRestaurantSize) {

        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : availableRestaurants) {
            if (restaurant.getCuisine() == category.getPrimaryCuisine() && restaurant.getCostBracket() == category.getPrimaryCostBracket() && restaurant.getRating() >= 4.0) {
                result.add(restaurant);
                sortedRestaurantSize++;
            }

            if(result.size() == restaurantLimit || sortedRestaurantSize > availableRestaurants.size())
                break;
        }
        return result;
    }
}
