package com.baduwal.ecommerce.controller;

import com.baduwal.ecommerce.data.CuisineType;
import com.baduwal.ecommerce.data.MealType;
import com.baduwal.ecommerce.data.StarRating;
import com.baduwal.ecommerce.entity.Restaurant;
import com.baduwal.ecommerce.searchers.RestaurantSearcher;
import com.baduwal.ecommerce.service.CuisinesTypeFilter;
import com.baduwal.ecommerce.service.MealTypeFilter;
import com.baduwal.ecommerce.service.RestaurantFilter;
import com.baduwal.ecommerce.service.StarRatingFilter;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcherAPI {

    public List<Restaurant> searchRestaurant(String restaurantName, MealType mealType, List<CuisineType> cuisineTypes, StarRating rating){
        // Validations
        List<RestaurantFilter> filters = new ArrayList<>();
        if (mealType != null){
            filters.add(new MealTypeFilter( mealType ));
        }
        if (cuisineTypes != null){
            filters.add(new CuisinesTypeFilter( cuisineTypes ));
        }
        if (rating != null){
            filters.add(new StarRatingFilter(rating));
        }

        return new RestaurantSearcher().search(restaurantName, filters);
    }
}
