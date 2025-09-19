package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.entity.FoodItem;
import com.baduwal.ecommerce.data.enums.CuisineType;
import com.baduwal.ecommerce.data.enums.MealType;
import com.baduwal.ecommerce.repo.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    @Override
    public FoodItem updateFoodItem(int id, FoodItem foodItem) {
        return null;
    }

    @Override
    public void deleteFoodItem(int id) {

    }

    @Override
    public FoodItem getFoodItemById(int id) {
        return null;
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return List.of();
    }

    @Override
    public List<FoodItem> getFoodItemsByRestaurant(int restaurantId) {
        return List.of();
    }

    @Override
    public List<FoodItem> getFoodItemsByMealType(MealType mealType) {
        return List.of();
    }

    @Override
    public List<FoodItem> getFoodItemsByCuisineType(CuisineType cuisineType) {
        return List.of();
    }

    @Override
    public List<FoodItem> getAvailableFoodItems() {
        return List.of();
    }
}
