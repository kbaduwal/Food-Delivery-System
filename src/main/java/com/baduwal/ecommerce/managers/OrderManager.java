package com.baduwal.ecommerce.managers;

import com.baduwal.ecommerce.data.DataAccessor;
import com.baduwal.ecommerce.data.OrderStatus;
import com.baduwal.ecommerce.entity.CartItem;
import com.baduwal.ecommerce.entity.Order;
import com.baduwal.ecommerce.entity.User;
import com.baduwal.ecommerce.factory.PermissionFactory;
import com.baduwal.ecommerce.permissions.Permission;

import java.util.List;

public class OrderManager {

    public Order placeOrder(User user){
        Permission permission = PermissionFactory.getPlaceOrderPermission(user);
        if (!permission.isPermitted()) {
            throw new RuntimeException("Permission denied");
        }

        CartManager cartManager = new CartManager();
        List<CartItem> cartItems = cartManager.getUserCart(user);
        int orderId = DataAccessor.createOrder(user, cartItems);
        cartManager.checkoutUserCart(user);
        return new Order(cartItems,orderId,user.getId(), OrderStatus.ORDER_PLACED);
    }

    public List<Order> getOrders(User user){
        return null;
    }

    public Order getOrder(int orderId){
        return null;
    }

    public void setOrderToCooking(User user, Order order){
        Permission permission =PermissionFactory.getUpdateOrderPermission(user, order, OrderStatus.COOKING);
        if (!permission.isPermitted()) {
            throw new RuntimeException("Permission denied");
        }

        if(!order.getOrderStatus().equals(OrderStatus.ORDER_PLACED)){
            throw new RuntimeException("Only ORDER_PLACED status can move to cooking.");
        }

        //logic to go into the  dataAccessor -> Write a method update the status of order to -> something we want
        //change the one row in data base( which will Update )
    }

    public void setOrderToReadyForDelivery(User user, Order order){
        if(!order.getOrderStatus().equals(OrderStatus.COOKING)){
            throw new RuntimeException("");
        }
    }

    public void setOrderToOutForDelivery(User user, Order order){
        if(!order.getOrderStatus().equals(OrderStatus.READY_FOR_DELIVERY)){
            throw new RuntimeException("");
        }
    }

    public void setOrderToOutForDelivered(User user, Order order){
        if(!order.getOrderStatus().equals(OrderStatus.OUT_OF_DELIVERY)){
            throw new RuntimeException("");
        }
    }

    public void setOrderToCancelled(User user, Order order){
        if(!order.getOrderStatus().equals(OrderStatus.ORDER_PLACED)){
            throw new RuntimeException("");
        }
    }

}

//OrderHistory
//GetOrder
//UpdateOrder