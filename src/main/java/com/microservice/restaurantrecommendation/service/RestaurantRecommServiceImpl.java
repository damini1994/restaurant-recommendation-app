package com.microservice.restaurantrecommendation.service;

import com.microservice.restaurantrecommendation.model.Cuisine;
import com.microservice.restaurantrecommendation.model.CuisineAndCostBracketCategory;
import com.microservice.restaurantrecommendation.model.Restaurant;
import com.microservice.restaurantrecommendation.model.User;
import com.microservice.restaurantrecommendation.service.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantRecommServiceImpl implements RestaurantRecommService{

    @Autowired
    CuisineTypeFactory typeFactory;

    @Autowired
    CostBracketFactory costBracketFactory;

    @Override
    public List<String> getRestaurantRecommendations(User user, List<Restaurant> availableRestaurants) {
         
        Cuisine primaryCuisine = typeFactory.getCuisine("primary").extractCuisineFromUser(user);
        Cuisine secondaryCuisine1 = typeFactory.getCuisine("secondary1").extractCuisineFromUser(user);
        Cuisine secondaryCuisine2 = typeFactory.getCuisine("secondary2").extractCuisineFromUser(user);

        int primaryCostBracket = costBracketFactory.getCuisine("primary").extractCostBracket(user);
        int secondaryCostBracket1 = costBracketFactory.getCuisine("secondary1").extractCostBracket(user);
        int secondaryCostBracket2 = costBracketFactory.getCuisine("secondary2").extractCostBracket(user);
        int restaurantLimit = 100;
        
        CuisineAndCostBracketCategory category = CuisineAndCostBracketCategory.builder().primaryCuisine(primaryCuisine).secondaryCuisine1(secondaryCuisine1)
                .secondaryCuisine2(secondaryCuisine2).primaryCostBracket(primaryCostBracket).secondaryCostBracket1(secondaryCostBracket1).secondaryCostBracket2(secondaryCostBracket2)
                .build();
                        

        List<Restaurant> sortedRestaurants = new ArrayList<>();

        List<RestaurantSortingStrategy> restaurantSorters = new ArrayList<>();
        restaurantSorters.add(new FeaturedPrimaryCuisineCostBracketStrategy(category ));
        restaurantSorters.add(new PrimaryCuisinePrimaryCostBracketHighRatingStrategy(category));
        restaurantSorters.add(new PrimaryCuisineSecondaryCostBracketHighRatingStrategy(category));
        restaurantSorters.add(new SecondaryCuisinePrimaryCostBracketHighRatingStrategy(category));
        restaurantSorters.add(new NewlyCreatedRestaurantByRatingStrategy(category));
        restaurantSorters.add(new PrimaryCuisinePrimaryCostBracketLowRatingStrategy(category));
        restaurantSorters.add(new PrimaryCuisineSecondaryCostBracketLowRatingStrategy(category));
        restaurantSorters.add(new SecondaryCuisinePrimaryCostBracketLowRatingStrategy(category));


        for (RestaurantSortingStrategy sorter : restaurantSorters) {
            List<Restaurant> restaurants = sorter.sortRestaurants(availableRestaurants, restaurantLimit, sortedRestaurants.size());
            sortedRestaurants.addAll(restaurants);
            restaurantLimit -= restaurants.size();
            // stop if we have reached the desired number of recommendations
            if (sortedRestaurants.size() >= 100 || sortedRestaurants.size() > availableRestaurants.size()) {
                break;
            }
        }

        List<String> restaurants = sortedRestaurants.stream().map(r-> r.getRestaurantId()).collect(Collectors.toList());
        return restaurants;
    }


}
