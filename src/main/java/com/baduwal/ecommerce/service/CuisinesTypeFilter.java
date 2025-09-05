package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.CuisineType;
import com.baduwal.ecommerce.entity.FoodItem;
import com.baduwal.ecommerce.entity.Restaurant;

import java.util.List;

public class CuisinesTypeFilter implements FoodItemFilter, RestaurantFilter {

    private final List<CuisineType> cuisineTypes;

    public CuisinesTypeFilter(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return cuisineTypes.contains(foodItem.getCuisineType());
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        List<CuisineType> cuisines = restaurant.getCuisines();
        for (CuisineType cuisineType : cuisineTypes) {
            if(cuisines.contains(cuisineType)) {
                return true;
            }
        }
        return false;
    }
}
