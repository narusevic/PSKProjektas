package com.travel.services;

import com.travel.models.Amenity;
import com.travel.models.AmenityItem;
import com.travel.repositories.AmenityItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AmenityItemServiceImpl implements AmenityItemService {
    @Autowired
    private AmenityItemRepository amenityItemRepository;

    @Override
    public Optional<AmenityItem> findById(Long id) {
        return amenityItemRepository.findById(id);
    }

    @Override
    public Set<AmenityItem> findByAmenity(Amenity amenity) {
        return amenityItemRepository.findByAmenity(amenity);
    }

    @Override
    public void save(AmenityItem amenityItem) {
        amenityItemRepository.save(amenityItem);
    }
}

