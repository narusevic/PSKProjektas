package com.travel.repositories;

import java.util.List;

import com.travel.models.Trip;
import com.travel.models.User;
import com.travel.models.UserTrip;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTripRepository extends JpaRepository<UserTrip, Long> {
    List<UserTrip> findByUserAndTrip(User user, Trip trip);

    List<UserTrip> findByUser(User user);
}