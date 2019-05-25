package com.travel.services;

import com.travel.models.Location;
import com.travel.models.Room;
import com.travel.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Optional<Room> findById(Long id){
        return roomRepository.findById(id);
    }

    @Override
    public Set<Room> findByNumber(int number){
        return roomRepository.findByNumber(number);
    }

    @Override
    public Set<Room> findByLocation(Location location){
        return roomRepository.findByLocation(location);
    }

    @Override
    public void save(Room room){
        roomRepository.save(room);
    }
}
