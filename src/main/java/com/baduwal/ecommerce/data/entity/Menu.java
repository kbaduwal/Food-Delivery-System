package com.baduwal.ecommerce.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Menu {

    private final List<FoodItem> foodItems;

}
