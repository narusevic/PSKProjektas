package com.travel.repositories;

import com.travel.models.Location;
import com.travel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findById(Long id);
    Set<Room> findByNumber(int number);
    Set<Room> findByLocation(Location location);
}
