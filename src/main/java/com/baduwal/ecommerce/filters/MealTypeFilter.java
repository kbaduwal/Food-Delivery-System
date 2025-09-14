package com.baduwal.ecommerce.filters;

import com.baduwal.ecommerce.data.enums.MealType;
import com.baduwal.ecommerce.data.entity.FoodItem;
import com.baduwal.ecommerce.data.entity.Restaurant;

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
