package com.hakan.otel.controller;

import com.hakan.otel.dto.Room.RoomAdminDTO;
import com.hakan.otel.dto.Room.RoomDTO;
import com.hakan.otel.entity.Room;
import com.hakan.otel.mapper.Room.RoomMapper;
import com.hakan.otel.service.RoomService.RoomService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // frontend için.
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    // Resepsiyonist endpoint
    @GetMapping("/rooms")
    public List<RoomDTO> getRoomsForReceptionist() {
        return roomService.findAllRooms().stream()
                .map(RoomMapper::toRoomDTO)
                .collect(Collectors.toList());
    }

    // Admin endpoint
    @GetMapping("/admin/rooms")
    public List<RoomAdminDTO> getRoomsForAdmin() {
        return roomService.findAllRooms().stream()
                .map(RoomMapper::toRoomAdminDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/rooms/{id}")
    public Optional<Room> getRoomById(@PathVariable(name="id") Long id){
        return roomService.findRoomById(id);
    }

    @PostMapping("/rooms")
    public RoomDTO createRoom(@RequestBody @Valid RoomAdminDTO roomAdminDTO) {
        Room room = RoomMapper.toRoom(roomAdminDTO);
        Room saved = roomService.saveRoom(room);
        return RoomMapper.toRoomDTO(saved);
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable(name="id") Long id){
        roomService.deleteRoom(id);
    }

}
