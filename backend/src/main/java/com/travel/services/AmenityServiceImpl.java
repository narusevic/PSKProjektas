package com.travel.services;

import com.travel.models.Amenity;
import com.travel.repositories.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AmenityServiceImpl implements AmenityService {

    @Autowired
    private AmenityRepository amenityRepository;

    @Override
    public void save(Amenity amenity) {
        amenityRepository.save(amenity);
    }

    @Override
    public Optional<Amenity> findById(Long id) {
        return amenityRepository.findById(id);
    }

    @Override
    public Set<Amenity> findByName(String name) {
        return amenityRepository.findByName(name);
    }

    @Override
    public Set<Amenity> findByDescription(String description) {
        return amenityRepository.findByDescription(description);
    }

    @Override
    public List<Amenity> findAll() {
        return amenityRepository.findAll();
    }
}
