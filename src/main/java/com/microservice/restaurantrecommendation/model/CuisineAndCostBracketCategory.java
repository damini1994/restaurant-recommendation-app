package com.microservice.restaurantrecommendation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
public class CuisineAndCostBracketCategory {

    private Cuisine primaryCuisine;
    private Cuisine secondaryCuisine1;
    private Cuisine secondaryCuisine2;
    private int primaryCostBracket;
    private int secondaryCostBracket1;
    private int secondaryCostBracket2;
}
