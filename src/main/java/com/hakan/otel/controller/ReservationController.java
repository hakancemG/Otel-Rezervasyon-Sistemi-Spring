package com.hakan.otel.controller;

import com.hakan.otel.dto.Reservation.ReservationAdminDTO;
import com.hakan.otel.dto.Reservation.ReservationDTO;
import com.hakan.otel.entity.Customer;
import com.hakan.otel.entity.Reservation;
import com.hakan.otel.entity.Room;
import com.hakan.otel.mapper.Reservation.ReservationMapper;
import com.hakan.otel.service.CustomerService.CustomerService;
import com.hakan.otel.service.ReservationService.ReservationService;
import com.hakan.otel.service.RoomService.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ReservationController {

    private final ReservationService reservationService;
    private final CustomerService customerService;
    private final RoomService roomService;

    public ReservationController(ReservationService reservationService, CustomerService customerService, RoomService roomService) {
        this.reservationService = reservationService;
        this.customerService = customerService;
        this.roomService = roomService;
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDTO>> findAllReservations() {
        List<ReservationDTO> dtoList = reservationService.findAllReservations()
                .stream()
                .map(ReservationMapper::toReservationDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/admin/reservations")
    public List<ReservationAdminDTO> getAllReservationsForAdmin() {
        return reservationService.findAllReservations()
                .stream()
                .map(ReservationMapper::toReservationAdminDTO)
                .collect(Collectors.toList());
    }


    @GetMapping("/reservation/{id}")
    public ResponseEntity<ReservationDTO> findReservationById(@PathVariable(name = "id") Long id) {
        Optional<Reservation> reservationOptional = reservationService.findReservationById(id);
        if (reservationOptional.isPresent()) {
            ReservationDTO dto = ReservationMapper.toReservationDTO(reservationOptional.get());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/admin/reservations")
    public ResponseEntity<ReservationAdminDTO> createReservation(@Valid @RequestBody ReservationAdminDTO reservationAdminDTO) {
        Customer customer = customerService.findCustomerById(reservationAdminDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + reservationAdminDTO.getCustomerId()));

        Room room = roomService.findRoomById(reservationAdminDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + reservationAdminDTO.getRoomId()));

        Reservation reservation = ReservationMapper.toReservation(reservationAdminDTO, customer, room);
        Reservation saved = reservationService.saveReservation(reservation);

        ReservationAdminDTO responseDto = ReservationMapper.toReservationAdminDTO(saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }



    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable(name = "id") Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
