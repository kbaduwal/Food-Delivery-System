package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.MealType;
import com.baduwal.ecommerce.entity.FoodItem;
import com.baduwal.ecommerce.entity.Restaurant;

public class MealTypeFilter implements FoodItemFilter, RestaurantFilter {

    private final MealType mealType;

    public MealTypeFilter(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getMealType().equals(mealType);
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getMealType().equals(mealType);
    }
}
