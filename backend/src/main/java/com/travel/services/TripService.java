package com.travel.services;

import java.util.List;

import com.travel.models.Trip;

public interface TripService {
    void save(Trip trip);
    Trip findById(Long id);
    List<Trip> findAll();
    List<Trip> findByOrganizerId(Long id);
    void deleteById(Long id);
    void merge(Long id, Long mergedId);
}