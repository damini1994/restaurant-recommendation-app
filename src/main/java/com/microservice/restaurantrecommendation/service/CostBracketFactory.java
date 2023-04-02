package com.microservice.restaurantrecommendation.service;

import org.springframework.stereotype.Service;

@Service
public class CostBracketFactory {

    public CostBracketService getCuisine(String costBracketType){
        if(costBracketType == null){
            return null;
        }
        if(costBracketType.equalsIgnoreCase("PRIMARY")){
            return new PrimaryCostBracket();

        } else if(costBracketType.equalsIgnoreCase("SECONDARY1")){
            return new SecondaryCostBracket1();

        } else if(costBracketType.equalsIgnoreCase("SECONDARY2")){
            return new SecondaryCostBracket1();
        }

        return null;
    }
}
