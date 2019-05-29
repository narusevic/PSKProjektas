package com.travel.services;

import com.travel.models.Location;
import com.travel.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> findAll(){
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public Set<Location> findByCity(String city) {
        return locationRepository.findByCity(city);
    }

    @Override
    public Set<Location> findByCountry(String country) {
        return locationRepository.findByCountry(country);
    }

    @Override
    public Set<Location> findByIsDevBridge(boolean isDevBridge) {
        return locationRepository.findByIsDevBridge(isDevBridge);
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location);
    }
}