package com.baduwal.ecommerce.permissions;

import com.baduwal.ecommerce.data.OrderStatus;
import com.baduwal.ecommerce.entity.Order;
import com.baduwal.ecommerce.entity.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateOrderPermission implements Permission {
    private final User user;
    private final Order order;
    private final OrderStatus orderStatus;

    @Override
    public boolean isPermitted() {
        return false;
    }
}
