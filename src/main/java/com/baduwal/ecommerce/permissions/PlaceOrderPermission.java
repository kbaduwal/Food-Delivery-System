package com.baduwal.ecommerce.permissions;

import com.baduwal.ecommerce.data.entity.User;


public class PlaceOrderPermission implements Permission {

    private final User user;

    public PlaceOrderPermission(User user) {
        this.user = user;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
