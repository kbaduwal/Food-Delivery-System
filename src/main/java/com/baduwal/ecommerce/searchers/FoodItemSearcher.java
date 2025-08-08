package com.baduwal.ecommerce.searchers;

//It could be a repository
//Fetching data from database
//Business class

import com.baduwal.ecommerce.entity.FoodItem;
import com.baduwal.ecommerce.service.FoodItemFilter;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcher {

    public List<FoodItem> search(String foodItemName, List<FoodItemFilter> filters) {
        if (foodItemName == null || foodItemName.length() == 0 || filters == null || filters.isEmpty()) {
            throw new IllegalArgumentException("foodItemName or foodItemName is null or empty");
        }

        DataAccessResult dataAccessResult = DataAccessor.getFoodItemsWithName(foodItemName);
        List<FoodItem> foodItems = DataAccessObjectConverter.convertToFoodItems(dataAccessResult);

        for(FoodItemFilter filter : filters) {
            List<FoodItem> filteredFFoodItems = new ArrayList<>();
            for(FoodItem foodItem : foodItems) {
                if(filter.filter(foodItem)){
                    filteredFFoodItems.add(foodItem);
                }
                foodItems=filteredFFoodItems;
            }

        }
        return foodItems;
    }

}
