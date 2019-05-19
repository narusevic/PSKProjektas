package com.travel.services;

import java.lang.reflect.Field;

import com.travel.models.Trip;
import com.travel.repositories.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    @Override
    public void save(Trip trip) {
        // Just a helper to print out all object properties before saving
        try {
            for (Field field : trip.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(trip);
                System.out.printf("%s: %s%n", name, value);
            }
        } catch(IllegalAccessException error) {
            System.out.printf("exception", error);
        }

        tripRepository.save(trip);
    }
}