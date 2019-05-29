package com.travel.services;

import com.travel.models.Location;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface LocationService {
    void save(Location location);
    List<Location> findAll();
    Optional<Location> findById(Long id);
    Set<Location> findByCity(String city);
    Set<Location> findByCountry(String country);
    Set<Location> findByIsDevBridge(boolean isDevBridge);
    Integer isAvailable(Long locationId, Date from, Date to);
}
