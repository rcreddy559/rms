package com.rooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rooms.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    
}
