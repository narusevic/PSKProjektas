package com.travel.services;

import com.travel.models.Route;

import java.util.List;

public interface RouteService {
    void save(Route trip);
    List<Route> findAll();
    Route findById(Long id);
    void deleteById(Long id);
}