package com.travel.services;


import com.travel.models.Accommodation;
import com.travel.models.Location;
import com.travel.models.User;

import java.util.Optional;
import java.util.Set;

public interface AccommodationService {
    Optional<Accommodation> findById(Long id);
    Set<Accommodation> findByUsers(Set<User> users);
    Set<Accommodation> findByLocation(Location location);
    void save(Accommodation accommodation);
}