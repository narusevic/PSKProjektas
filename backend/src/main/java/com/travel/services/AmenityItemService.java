package com.travel.services;

import com.travel.models.Amenity;
import com.travel.models.AmenityItem;

import java.util.Optional;
import java.util.Set;

public interface AmenityItemService {
    Optional<AmenityItem> findById(Long id);
    Set<AmenityItem> findByAmenity(Amenity amenity);
    void save(AmenityItem amenityItem);
}
