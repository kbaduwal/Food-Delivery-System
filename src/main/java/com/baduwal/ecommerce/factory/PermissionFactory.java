package com.baduwal.ecommerce.factory;

import com.baduwal.ecommerce.data.OrderStatus;
import com.baduwal.ecommerce.entity.FoodItem;
import com.baduwal.ecommerce.entity.Order;
import com.baduwal.ecommerce.entity.User;
import com.baduwal.ecommerce.permissions.*;

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

    public static Permission getPlaceOrderPermission(User user){
        return new PlaceOrderPermission(user);
    }

    public static Permission getUpdateOrderPermission(User user, Order order, OrderStatus orderStatus){
        return new UpdateOrderPermission(user, order, orderStatus);
    }


}
