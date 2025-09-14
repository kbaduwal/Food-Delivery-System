package com.baduwal.ecommerce.api;

import com.baduwal.ecommerce.data.enums.CuisineType;
import com.baduwal.ecommerce.data.enums.MealType;
import com.baduwal.ecommerce.data.enums.StarRating;
import com.baduwal.ecommerce.data.entity.Restaurant;
import com.baduwal.ecommerce.searchers.RestaurantSearcher;
import com.baduwal.ecommerce.filters.CuisinesTypeFilter;
import com.baduwal.ecommerce.filters.MealTypeFilter;
import com.baduwal.ecommerce.filters.RestaurantFilter;
import com.baduwal.ecommerce.filters.StarRatingFilter;

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
