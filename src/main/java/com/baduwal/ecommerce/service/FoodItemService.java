package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.entity.FoodItem;
import com.baduwal.ecommerce.data.enums.CuisineType;
import com.baduwal.ecommerce.data.enums.MealType;

import java.util.List;

public interface FoodItemService {
    FoodItem createFoodItem(FoodItem foodItem);
    FoodItem updateFoodItem(int id, FoodItem foodItem);
    void deleteFoodItem(int id);
    FoodItem getFoodItemById(int id);
    List<FoodItem> getAllFoodItems();
    List<FoodItem> getFoodItemsByRestaurant(int restaurantId);
    List<FoodItem> getFoodItemsByMealType(MealType mealType);
    List<FoodItem> getFoodItemsByCuisineType(CuisineType cuisineType);
    List<FoodItem> getAvailableFoodItems();

}
