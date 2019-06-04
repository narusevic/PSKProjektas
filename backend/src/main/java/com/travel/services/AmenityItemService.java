package com.travel.services;

import com.travel.models.Amenity;
import com.travel.models.AmenityItem;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AmenityItemService {
    Optional<AmenityItem> findById(Long id);
    Set<AmenityItem> findByAmenity(Amenity amenity);
    List<AmenityItem> findAll();
    void save(AmenityItem amenityItem);
}
