package com.rooms.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.rooms.entity.RoomEntity;
import com.rooms.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
 
    public List<RoomEntity> getRooms() {
        return roomRepository.findAll();
    }
}
