package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.entity.Restaurant;
import com.baduwal.ecommerce.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant);
    public Optional<Restaurant> getRestaurantById(int id);
    public List<Restaurant> getAllRestaurants();
    public boolean deleteRestaurantById(int id);
}
