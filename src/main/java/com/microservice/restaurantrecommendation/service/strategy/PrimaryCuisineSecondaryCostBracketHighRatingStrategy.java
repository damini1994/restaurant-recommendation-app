package com.microservice.restaurantrecommendation.service.strategy;

import com.microservice.restaurantrecommendation.model.CuisineAndCostBracketCategory;
import com.microservice.restaurantrecommendation.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class PrimaryCuisineSecondaryCostBracketHighRatingStrategy implements RestaurantSortingStrategy {

    private CuisineAndCostBracketCategory category;

    public PrimaryCuisineSecondaryCostBracketHighRatingStrategy(CuisineAndCostBracketCategory category) {
        this.category = category;
    }

    @Override
    public List<Restaurant> sortRestaurants(List<Restaurant> availableRestaurants, int restaurantLimit, int sortedRestaurantSize) {

        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : availableRestaurants) {
            if (restaurant.getCuisine() == category.getPrimaryCuisine() && (restaurant.getCostBracket() == category.getSecondaryCostBracket1() || restaurant.getCostBracket() == category.getSecondaryCostBracket2() )&& restaurant.getRating() >= 4.5) {
                result.add(restaurant);
                sortedRestaurantSize++;
            }

            if(result.size() == restaurantLimit || sortedRestaurantSize > availableRestaurants.size())
                break;
        }
        return result;
    }
}
