package com.travel.services;

import com.travel.models.Amenity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AmenityService {

    void save(Amenity amenity);
    List<Amenity> findAll();
    Optional<Amenity> findById(Long id);
    Set<Amenity> findByName(String name);
    Set<Amenity> findByDescription(String description);
}
