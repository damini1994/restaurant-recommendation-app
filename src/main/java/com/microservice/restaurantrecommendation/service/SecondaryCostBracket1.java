package com.microservice.restaurantrecommendation.service;

import com.microservice.restaurantrecommendation.model.User;

public class SecondaryCostBracket1 implements CostBracketService{
    @Override
    public int extractCostBracket(User user) {
        return user.getCostBrackets().size() > 1 ? user.getCostBrackets().get(1).getType() : 0;
    }
}
