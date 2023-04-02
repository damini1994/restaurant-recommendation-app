package com.microservice.restaurantrecommendation.service.strategy;

import com.microservice.restaurantrecommendation.model.CuisineAndCostBracketCategory;
import com.microservice.restaurantrecommendation.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class SecondaryCuisinePrimaryCostBracketHighRatingStrategy implements RestaurantSortingStrategy{

    private CuisineAndCostBracketCategory category;

    public SecondaryCuisinePrimaryCostBracketHighRatingStrategy(CuisineAndCostBracketCategory category ) {
        this.category = category;
    }

    @Override
    public List<Restaurant> sortRestaurants(List<Restaurant> availableRestaurants, int restaurantLimit, int sortedRestaurantSize) {

        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : availableRestaurants) {
            if ((restaurant.getCuisine() == category.getSecondaryCuisine1() || restaurant.getCuisine() == category.getSecondaryCuisine2()) && restaurant.getCostBracket() == category.getPrimaryCostBracket() && restaurant.getRating() >= 4.5) {
                result.add(restaurant);
                sortedRestaurantSize++;
            }

            if(result.size() == restaurantLimit || sortedRestaurantSize > availableRestaurants.size())
                break;
        }
        return result;
    }
}
