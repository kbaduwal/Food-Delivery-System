package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.CuisineType;
import com.baduwal.ecommerce.entity.FoodItem;

import java.util.List;

public class CuisinesTypeFilter implements FoodItemFilter {

    private final List<CuisineType> cuisineTypes;

    public CuisinesTypeFilter(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return cuisineTypes.contains(foodItem.getCuisineType());
    }
}
