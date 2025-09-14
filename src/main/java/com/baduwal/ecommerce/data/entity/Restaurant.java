package com.baduwal.ecommerce.data.entity;

import com.baduwal.ecommerce.data.enums.CuisineType;
import com.baduwal.ecommerce.data.enums.MealType;
import com.baduwal.ecommerce.data.enums.StarRating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Restaurant {
    private final int id;
    private final String name;
    private final String description;
    private final BusinessHours businessHours;
    private final MealType mealType;
    private final List<CuisineType> cuisines;
    private final StarRating rating;
    private final Menu menu;
    private final Address address;
}
