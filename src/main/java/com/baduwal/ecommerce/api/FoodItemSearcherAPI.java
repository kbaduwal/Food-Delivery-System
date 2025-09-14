package com.baduwal.ecommerce.api;

import com.baduwal.ecommerce.data.CuisineType;
import com.baduwal.ecommerce.data.MealType;
import com.baduwal.ecommerce.data.StarRating;
import com.baduwal.ecommerce.entity.FoodItem;
import com.baduwal.ecommerce.searchers.FoodItemSearcher;
import com.baduwal.ecommerce.service.*;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcherAPI {

    public List<FoodItem> searchFoodItem(String foodItem, MealType mealType, List<CuisineType> cuisineTypes, StarRating rating){
        // Validations
        if(foodItem == null || foodItem.isEmpty()){
            throw new IllegalArgumentException("foodItem is null or empty");
        }

        List<FoodItemFilter> filters = new ArrayList<>();
        if (mealType != null){
            filters.add(new MealTypeFilter( mealType ));
        }
        if (cuisineTypes != null){
            filters.add(new CuisinesTypeFilter( cuisineTypes ));
        }
        if (rating != null){
            filters.add(new StarRatingFilter(rating));
        }

        return new FoodItemSearcher().search(foodItem, filters);
    }

}



// Searcher : Generic : OCP
// Get only those food items whose (name matches foodItemName) AND (mT is mealType) AND (cT is cuisines) AND (r > rating)
// Filters F1, F2, F3...
// --foodItem --> F --T/F-->
// List of foodItems
// Filters


