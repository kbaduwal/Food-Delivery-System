package com.baduwal.ecommerce.data;

import com.baduwal.ecommerce.entity.CartItem;
import com.baduwal.ecommerce.entity.FoodItem;

import java.util.List;

public class DataAccessObjectConverter {

    private DataAccessObjectConverter() {}

    public static List<CartItem> convertToCartItems(DataAccessResult result) {
        return null;
    }

    public static List<FoodItem> convertToFoodItems(DataAccessResult result) {
        // Convert to FoodItem objects
        return null;
    }

}
