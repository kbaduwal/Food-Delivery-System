package com.baduwal.ecommerce.data;

import com.baduwal.ecommerce.entity.CartItem;
import com.baduwal.ecommerce.entity.FoodItem;
import com.baduwal.ecommerce.entity.User;

import java.util.List;

public class DataAccessor {

    private DataAccessor() {}

    public static void addItemToCart(User user, FoodItem foodItem) {

    }

    public static DataAccessResult getFoodItemWithName(String name){
        return null;
    }

    public static DataAccessResult getUserCart(User user) {
        return null;
    }

    public static void deleteItemFromCart(User user, FoodItem foodItem) {

    }

    public static void checkOutCart(User user){

    }

    public static int createOrder(User user, List<CartItem> cartItems) {
        return 1;
    }

}
