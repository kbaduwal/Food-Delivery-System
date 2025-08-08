package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.entity.FoodItem;

public interface FoodItemFilter {
    boolean filter(FoodItem foodItem);
}
