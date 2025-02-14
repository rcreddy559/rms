package com.rooms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rooms.entity.RoomEntity;
import com.rooms.service.RoomService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;
    RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<RoomEntity> getRooms() {
        return roomService.getRooms();
    }
    
    
}
