package com.baduwal.ecommerce.filters;

import com.baduwal.ecommerce.data.entity.Restaurant;

public interface RestaurantFilter {

    boolean filter(Restaurant restaurant);
}
