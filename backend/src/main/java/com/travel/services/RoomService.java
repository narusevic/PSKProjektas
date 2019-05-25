package com.travel.services;

import com.travel.models.Location;
import com.travel.models.Room;

import java.util.Optional;
import java.util.Set;

public interface RoomService {

    void save(Room room);
    Optional<Room> findById(Long id);
    Set<Room> findByNumber(int number);
    Set<Room> findByLocation(Location location);
}
