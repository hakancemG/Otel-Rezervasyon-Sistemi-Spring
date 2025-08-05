package com.hakan.otel.service.ReservationService;

import com.hakan.otel.entity.Reservation;
import com.hakan.otel.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findReservationById(Long id){
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }
}
