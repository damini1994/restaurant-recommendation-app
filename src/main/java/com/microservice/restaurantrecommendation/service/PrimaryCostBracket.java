package com.microservice.restaurantrecommendation.service;

import com.microservice.restaurantrecommendation.model.User;

public class PrimaryCostBracket implements CostBracketService{

    @Override
    public int extractCostBracket(User user) {
        return user.getCostBrackets().size() > 0 ? user.getCostBrackets().get(0).getType() : 0;
    }
}
