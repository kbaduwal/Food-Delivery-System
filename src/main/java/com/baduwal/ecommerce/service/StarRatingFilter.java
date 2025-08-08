package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.StarRating;
import com.baduwal.ecommerce.entity.FoodItem;

public class StarRatingFilter implements FoodItemFilter{

    private final StarRating rating;

    public StarRatingFilter(StarRating rating) {
        this.rating = rating;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getStarRating().getVal()>=rating.getVal();
    }
}
