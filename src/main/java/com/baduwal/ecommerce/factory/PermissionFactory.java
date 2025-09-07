package com.baduwal.ecommerce.factory;

import com.baduwal.ecommerce.entity.FoodItem;
import com.baduwal.ecommerce.entity.User;
import com.baduwal.ecommerce.permissions.AddToCartPermission;
import com.baduwal.ecommerce.permissions.CheckoutCartPermission;
import com.baduwal.ecommerce.permissions.DeleteFromCartPermission;
import com.baduwal.ecommerce.permissions.Permission;

public class PermissionFactory {

    private PermissionFactory() {

    }

    public static Permission getAddToCartPermission(User user, FoodItem foodItem){
        return new AddToCartPermission(user, foodItem);

    }

    public static Permission getDeleteFromCartPermission(User user, FoodItem foodItem){
        return new DeleteFromCartPermission(user, foodItem);

    }

    public static Permission getCheckOutCartPermission(User user){
        return new CheckoutCartPermission(user);

    }


}
