package com.baduwal.ecommerce.api;

import com.baduwal.ecommerce.data.OrderStatus;
import com.baduwal.ecommerce.entity.Order;
import com.baduwal.ecommerce.entity.User;
import com.baduwal.ecommerce.managers.OrderManager;
import com.baduwal.ecommerce.managers.UserManager;

public class UpdateOrderAPI {

    UserManager userManager = new UserManager();
    OrderManager orderManager = new OrderManager();


    public void updateOrder(int orderId, OrderStatus status, String userToken){
        //check Validate Parameter
        User user = userManager.getUserByToken(userToken);
        if (user == null) {
            throw new RuntimeException("Invalid user token");
        }

        Order order = orderManager.getOrder(orderId);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }

        if(status.equals(OrderStatus.COOKING)){
            orderManager.setOrderToCooking(user, order);
        }
        //... and so on for other status

    }
}
