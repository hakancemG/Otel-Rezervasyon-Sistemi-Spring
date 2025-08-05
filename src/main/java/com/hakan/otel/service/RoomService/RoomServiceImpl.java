package com.hakan.otel.service.RoomService;

import com.hakan.otel.entity.Room;
import com.hakan.otel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    // Constructor Injection.
    public RoomServiceImpl(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAllRooms(){
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> findRoomById(Long id){
        return roomRepository.findById(id);
    }

    @Override
    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id){
        roomRepository.deleteById(id);
    }

}
