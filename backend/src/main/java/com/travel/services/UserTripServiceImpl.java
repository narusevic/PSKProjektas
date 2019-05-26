package com.travel.services;

import com.travel.models.Trip;
import com.travel.models.User;
import com.travel.models.UserTrip;
import com.travel.repositories.UserTripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
@Service
public class UserTripServiceImpl implements UserTripService {
    @Autowired
    private UserTripRepository userTripRepository;

    @Override
    public void save(UserTrip userTrip) {
        // Just a helper to print out all object properties before saving
        try {
            for (Field field : userTrip.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(userTrip);
                System.out.printf("%s: %s%n", name, value);
            }
        } catch(IllegalAccessException error) {
            System.out.printf("exception", error);
        }

        userTripRepository.save(userTrip);
    }

    @Override
    public UserTrip findOneByUserAndTrip(User user, Trip trip) {
        List<UserTrip> userTrips = userTripRepository.findByUserAndTrip(user, trip);

        if (userTrips.size() > 0) {
            return userTrips.get(0);
        }

        return null;
    }

    @Override
    public List<UserTrip> findByUser(User user) {
        return userTripRepository.findByUser(user);
    }

    @Override 
    public void approveTrip(User user, Trip trip) {
        List<UserTrip> userTrips = userTripRepository.findByUserAndTrip(user, trip);

        if (userTrips.size() > 0) {
            UserTrip userTrip = userTrips.get(0);
            Boolean isApproved = userTrip.getUserApproved();
            userTrip.setUserApproved(!isApproved);
            userTripRepository.save(userTrip);
        }
    }

    @Override 
    public void deleteUserTrip(User user, Trip trip) {
        List<UserTrip> userTrips = userTripRepository.findByUserAndTrip(user, trip);

        userTripRepository.deleteAll(userTrips);
    }
}