package com.travel.services;

import java.util.List;

import com.travel.models.Trip;
import com.travel.models.User;
import com.travel.models.UserTrip;

public interface UserTripService {
    void save(UserTrip userTrip);

    UserTrip findOneByUserAndTrip(User user, Trip trip);

    List<UserTrip> findByUser(User user);

    void approveTrip(User user, Trip trip);

    void deleteUserTrip(User user, Trip trip); 
}