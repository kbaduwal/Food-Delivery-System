package com.baduwal.ecommerce.controller;

import com.baduwal.ecommerce.data.CuisineType;
import com.baduwal.ecommerce.data.MealType;
import com.baduwal.ecommerce.data.StarRating;
import com.baduwal.ecommerce.entity.FoodItem;

import java.util.List;

public class FoodItemSearcher {

    public List<FoodItem> searchFoodItem(String foodItem, MealType mealType, List<CuisineType> cuisines, StarRating rating){
        return null;
    }

}

// Searcher : Generic : OCP
// Get only those food items whose (name matches foodItemName) AND (mT is mealType) AND (cT is cuisines) AND (r > rating)
// Filters F1, F2, F3...
// --foodItem --> F --T/F-->
// List of foodItems
// Filters


