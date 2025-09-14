package com.baduwal.ecommerce.filters;

import com.baduwal.ecommerce.data.enums.StarRating;
import com.baduwal.ecommerce.data.entity.FoodItem;
import com.baduwal.ecommerce.data.entity.Restaurant;

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
