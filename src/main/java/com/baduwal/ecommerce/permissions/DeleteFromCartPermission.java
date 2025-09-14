package com.baduwal.ecommerce.permissions;

import com.baduwal.ecommerce.data.entity.FoodItem;
import com.baduwal.ecommerce.data.entity.User;

public class DeleteFromCartPermission implements Permission {

    private final User user;
    private final FoodItem foodItem;

    public DeleteFromCartPermission(User user, FoodItem foodItem) {
        this.user = user;
        this.foodItem = foodItem;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
