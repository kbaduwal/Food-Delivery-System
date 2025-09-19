package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.entity.Restaurant;
import com.baduwal.ecommerce.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Optional<Restaurant> getRestaurantById(int id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public boolean deleteRestaurantById(int id) {

        if (restaurantRepository.existsById(id)) {
            restaurantRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
