package com.baduwal.ecommerce.api;

import com.baduwal.ecommerce.entity.FoodItem;
import com.baduwal.ecommerce.entity.User;
import com.baduwal.ecommerce.managers.CartManager;
import com.baduwal.ecommerce.managers.UserManager;
import com.baduwal.ecommerce.searchers.FoodItemSearcher;

public class AddToCartAPI {
    private final UserManager userManager = new UserManager();
    private final FoodItemSearcher foodItemSearcher = new FoodItemSearcher();
    private final CartManager cartManager = new CartManager();

    public void addToCart(String userToken, int foodItemId) {
        if (userToken == null || userToken.isEmpty() || foodItemId < 0) {
            //
         }

        User user = userManager.getUserByToken(userToken);
        if (user == null) {
            //
        }

        FoodItem foodItem =foodItemSearcher.searchById(foodItemId);
        if (foodItem == null) {
            //
        }

        cartManager.addItemToCart(user, foodItem);

    }
}
