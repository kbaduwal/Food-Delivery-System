package com.baduwal.ecommerce.entity;


import com.baduwal.ecommerce.data.CuisineType;
import com.baduwal.ecommerce.data.MealType;
import com.baduwal.ecommerce.data.StarRating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItem {

    //Implement using Builder pattern later as we have too many parameter

    private final int id;
    private final String name;
    private final String description;
    private final double price;
    private final MealType mealType;
    private final CuisineType cuisineType;
    private final StarRating starRating;
    private final int restaurantId;
    private final boolean isAvailable;

    public FoodItem(int id, String name, String description, double price, MealType mealType, CuisineType cuisineType, StarRating starRating, int restaurantId, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.mealType = mealType;
        this.cuisineType = cuisineType;
        this.starRating = starRating;
        this.restaurantId = restaurantId;
        this.isAvailable = isAvailable;
    }
}
