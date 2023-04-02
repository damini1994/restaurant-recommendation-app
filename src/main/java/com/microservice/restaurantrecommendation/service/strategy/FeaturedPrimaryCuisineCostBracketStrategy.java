package com.microservice.restaurantrecommendation.service.strategy;

import com.microservice.restaurantrecommendation.model.CuisineAndCostBracketCategory;
import com.microservice.restaurantrecommendation.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class FeaturedPrimaryCuisineCostBracketStrategy implements RestaurantSortingStrategy {

    private CuisineAndCostBracketCategory category;

    public FeaturedPrimaryCuisineCostBracketStrategy(CuisineAndCostBracketCategory category) {
        this.category = category;
    }

    @Override
    public List<Restaurant> sortRestaurants(List<Restaurant> availableRestaurants, int restaurantLimit, int sortedRestaurantSize) {

        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : availableRestaurants) {
            if (restaurant.isRecommended() && restaurant.getCuisine() == category.getPrimaryCuisine() && restaurant.getCostBracket() == category.getPrimaryCostBracket()) {
                result.add(restaurant);
                sortedRestaurantSize++;
            }
            if(result.size() == restaurantLimit || sortedRestaurantSize > availableRestaurants.size())
                break;
        }
        if (result.isEmpty()) {
            for (Restaurant restaurant : availableRestaurants) {
                if (restaurant.isRecommended() && restaurant.getCuisine() == category.getPrimaryCuisine() && (restaurant.getCostBracket() == category.getSecondaryCostBracket1() || restaurant.getCostBracket() == category.getSecondaryCostBracket2())) {
                    result.add(restaurant);
                    sortedRestaurantSize++;
                }

                if(result.size() == restaurantLimit || sortedRestaurantSize > availableRestaurants.size())
                    break;
            }
            for (Restaurant restaurant : availableRestaurants) {
                if (restaurant.isRecommended() && (restaurant.getCuisine() == category.getSecondaryCuisine1() || restaurant.getCuisine() == category.getSecondaryCuisine2()) && restaurant.getCostBracket() == category.getPrimaryCostBracket()) {
                    result.add(restaurant);
                    sortedRestaurantSize++;
                }

                if(result.size() == restaurantLimit || sortedRestaurantSize > availableRestaurants.size())
                    break;
            }
            for (Restaurant restaurant : availableRestaurants) {
                if (restaurant.isRecommended() && restaurant.getCuisine() == category.getPrimaryCuisine() && restaurant.getCostBracket() == category.getSecondaryCostBracket1()) {
                    result.add(restaurant);
                    sortedRestaurantSize++;
                }

                if(result.size() == restaurantLimit || sortedRestaurantSize > availableRestaurants.size())
                    break;
            }
        }
        return result;
    }
}
