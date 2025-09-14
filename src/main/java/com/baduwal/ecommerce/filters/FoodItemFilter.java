package com.baduwal.ecommerce.filters;

import com.baduwal.ecommerce.data.entity.FoodItem;

public interface FoodItemFilter {
    boolean filter(FoodItem foodItem);
}
