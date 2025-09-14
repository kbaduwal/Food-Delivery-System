package com.baduwal.ecommerce.data.entity;

import com.baduwal.ecommerce.data.enums.OrderStatus;
import lombok.Getter;

import java.util.List;

@Getter
public class Order {

    private final List<CartItem> cartItems;
    private final int orderId;
    private final int userId;
    private final OrderStatus orderStatus;

    public Order(List<CartItem> cartItems, int orderId, int userId, OrderStatus orderStatus) {
        this.cartItems = cartItems;
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
    }
}
