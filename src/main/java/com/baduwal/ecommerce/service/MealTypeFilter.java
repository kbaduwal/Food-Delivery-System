package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.MealType;
import com.baduwal.ecommerce.entity.FoodItem;

public class MealTypeFilter implements FoodItemFilter {

    private final MealType mealType;

    public MealTypeFilter(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getMealType().equals(mealType);
    }
}
