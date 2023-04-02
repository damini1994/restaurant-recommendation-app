package com.microservice.restaurantrecommendation.model;

import lombok.Data;

import java.util.List;

@Data
public class ClientDataDTO {
    private User user;
    private List<Restaurant> restaurantList;
}
