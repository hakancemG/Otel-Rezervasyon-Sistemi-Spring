package com.hakan.otel.mapper.Room;

import com.hakan.otel.dto.Room.RoomDTO;
import com.hakan.otel.dto.Room.RoomAdminDTO;
import com.hakan.otel.entity.Room;

public class RoomMapper {

    public static RoomDTO toRoomDTO(Room room) {
        return RoomDTO.builder()
                .id(room.getId())
                .roomName(room.getRoomName())
                .type(room.getType())
                .capacity(room.getCapacity())
                .price(room.getPrice())
                .imagePath(room.getImagePath())
                .build();
    }

    public static RoomAdminDTO toRoomAdminDTO(Room room) {
        return RoomAdminDTO.builder()
                .id(room.getId())
                .roomName(room.getRoomName())
                .type(room.getType())
                .description(room.getDescription())
                .capacity(room.getCapacity())
                .price(room.getPrice())
                .imagePath(room.getImagePath())
                .build();
    }

    public static Room toRoom(RoomDTO dto) {
        return Room.builder()
                .id(dto.getId())
                .roomName(dto.getRoomName())
                .type(dto.getType())
                .capacity(dto.getCapacity())
                .price(dto.getPrice())
                .imagePath(dto.getImagePath())
                .build();
    }

    public static Room toRoom(RoomAdminDTO dto) {
        return Room.builder()
                .id(dto.getId())
                .roomName(dto.getRoomName())
                .type(dto.getType())
                .description(dto.getDescription())
                .capacity(dto.getCapacity())
                .price(dto.getPrice())
                .imagePath(dto.getImagePath())
                .build();
    }
}
