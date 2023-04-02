package com.microservice.restaurantrecommendation.controller;

import com.microservice.restaurantrecommendation.model.ClientDataDTO;
import com.microservice.restaurantrecommendation.model.Restaurant;
import com.microservice.restaurantrecommendation.model.User;
import com.microservice.restaurantrecommendation.service.RestaurantRecommService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantRecommendationController {

    private final RestaurantRecommService recommendationService;

    public RestaurantRecommendationController(RestaurantRecommService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/recommendations")
    public List<String> getRestaurantRecommendations(@RequestBody ClientDataDTO clientDataDTO) {
        return recommendationService.getRestaurantRecommendations(clientDataDTO.getUser(), clientDataDTO.getRestaurantList());
    }
}