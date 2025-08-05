package com.hakan.otel.mapper.Reservation;

import com.hakan.otel.dto.Reservation.ReservationAdminDTO;
import com.hakan.otel.dto.Reservation.ReservationDTO;
import com.hakan.otel.entity.Customer;
import com.hakan.otel.entity.Reservation;
import com.hakan.otel.entity.Room;

public class ReservationMapper {

    // Resepsiyonist DTO -> Entity
    public static Reservation toReservation(ReservationDTO dto, Customer customer, Room room) {
        return Reservation.builder()
                .status(dto.getStatus())
                .customer(customer)
                .room(room)
                .build();
    }

    // Entity -> Resepsiyonist DTO
    public static ReservationDTO toReservationDTO(Reservation reservation) {
        return ReservationDTO.builder()
                .id(reservation.getId())
                .status(reservation.getStatus())
                .customerId(reservation.getCustomer().getId())
                .roomId(reservation.getRoom().getId())
                .build();
    }

    // Admin DTO -> Entity
    public static Reservation toReservation(ReservationAdminDTO dto, Customer customer, Room room) {
        return Reservation.builder()
                .id(dto.getId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .status(dto.getStatus())
                .totalPrice(dto.getTotalPrice())
                .customer(customer)
                .room(room)
                .build();
    }

    // Entity -> Admin DTO
    public static ReservationAdminDTO toReservationAdminDTO(Reservation reservation) {
        return ReservationAdminDTO.builder()
                .id(reservation.getId())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .status(reservation.getStatus())
                .totalPrice(reservation.getTotalPrice())
                .customerId(reservation.getCustomer().getId())
                .roomId(reservation.getRoom().getId())
                .build();
    }
}
