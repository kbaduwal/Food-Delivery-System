package com.baduwal.ecommerce.permissions;

import com.baduwal.ecommerce.data.entity.User;

public class CheckoutCartPermission implements Permission{

    private final User user;

    public CheckoutCartPermission(User user) {
        this.user = user;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
