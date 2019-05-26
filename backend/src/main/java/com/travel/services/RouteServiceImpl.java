package com.travel.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import com.travel.models.Route;
import com.travel.repositories.RouteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository tripRepository;

    @Override
    public void save(Route route) {
        // Just a helper to print out all object properties before saving
        try {
            for (Field field : route.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(route);
                System.out.printf("%s: %s%n", name, value);
            }
        } catch(IllegalAccessException error) {
            System.out.printf("exception", error);
        }

        tripRepository.save(route);
    }

    @Override
    public List<Route> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public Route findById(Long id) {

        Optional<Route> optionalRoute = tripRepository.findById(id);
        if(optionalRoute.isPresent()){
            return optionalRoute.get();
        }

        return null;
    }
}