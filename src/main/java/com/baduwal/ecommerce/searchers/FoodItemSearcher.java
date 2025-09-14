package com.baduwal.ecommerce.searchers;

//It could be a repository
//Fetching data from database
//Business class

import com.baduwal.ecommerce.data.DataAccessObjectConverter;
import com.baduwal.ecommerce.data.DataAccessResult;
import com.baduwal.ecommerce.data.DataAccessor;
import com.baduwal.ecommerce.data.entity.FoodItem;
import com.baduwal.ecommerce.filters.FoodItemFilter;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcher {

    public List<FoodItem> search(String foodItemName, List<FoodItemFilter> filters) {
        if (foodItemName == null || foodItemName.length() == 0 || filters == null || filters.isEmpty()) {
            throw new IllegalArgumentException("foodItemName or foodItemName is null or empty");
        }

        DataAccessResult dataAccessResult = DataAccessor.getFoodItemWithName(foodItemName);
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

    public FoodItem searchById(int id) {
        return null;
    }

}
