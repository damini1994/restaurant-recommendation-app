package com.microservice.restaurantrecommendation.service;

import org.springframework.stereotype.Service;

@Service
public class CuisineTypeFactory {

    public CuisineTypeService getCuisine(String cuisineType){
        if(cuisineType == null){
            return null;
        }
        if(cuisineType.equalsIgnoreCase("PRIMARY")){
            return new PrimaryCuisine();

        } else if(cuisineType.equalsIgnoreCase("SECONDARY1")){
            return new SecondaryCuisine1();

        } else if(cuisineType.equalsIgnoreCase("SECONDARY2")){
            return new SecondaryCuisine2();
        }

        return null;
    }
}
