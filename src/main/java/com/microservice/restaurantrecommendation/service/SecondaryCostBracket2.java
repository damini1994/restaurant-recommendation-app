package com.microservice.restaurantrecommendation.service;

import com.microservice.restaurantrecommendation.model.User;

public class SecondaryCostBracket2 implements CostBracketService{
    @Override
    public int extractCostBracket(User user) {
        return user.getCostBrackets().size() > 2 ? user.getCostBrackets().get(2).getType() : 0;
    }
}
