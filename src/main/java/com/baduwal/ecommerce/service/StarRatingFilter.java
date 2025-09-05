package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.StarRating;
import com.baduwal.ecommerce.entity.FoodItem;
import com.baduwal.ecommerce.entity.Restaurant;

public class StarRatingFilter implements FoodItemFilter, RestaurantFilter{

    private final StarRating rating;

    public StarRatingFilter(StarRating rating) {
        this.rating = rating;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getStarRating().getVal()>=rating.getVal();
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getRating().getVal()>=rating.getVal();
    }
}
