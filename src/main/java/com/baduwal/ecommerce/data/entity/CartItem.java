package com.baduwal.ecommerce.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartItem {
    private final FoodItem foodItem;
    private final int quantity;
}
