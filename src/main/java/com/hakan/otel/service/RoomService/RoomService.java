package com.hakan.otel.service.RoomService;

import com.hakan.otel.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> findAllRooms();

    Optional<Room> findRoomById(Long id);

    Room saveRoom(Room room);

    void deleteRoom(Long id);
}
