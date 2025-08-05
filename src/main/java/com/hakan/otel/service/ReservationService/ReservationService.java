package com.hakan.otel.service.ReservationService;

import com.hakan.otel.entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> findAllReservations();

    Optional<Reservation> findReservationById(Long id);

    Reservation saveReservation(Reservation reservation);

    void deleteReservation(Long id);
}
