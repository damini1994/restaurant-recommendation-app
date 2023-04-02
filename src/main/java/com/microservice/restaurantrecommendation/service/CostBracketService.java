package com.microservice.restaurantrecommendation.service;

import com.microservice.restaurantrecommendation.model.User;

public interface CostBracketService {

    int extractCostBracket(User user);
}
