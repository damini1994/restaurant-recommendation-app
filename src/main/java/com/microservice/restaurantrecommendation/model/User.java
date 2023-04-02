package com.microservice.restaurantrecommendation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private List<CuisineTracking> cuisines;
    private List<CostTracking> costBrackets;
}
