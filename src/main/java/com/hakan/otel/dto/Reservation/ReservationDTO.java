package com.hakan.otel.dto.Reservation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDTO {

    private Long id;

    @NotBlank(message = "Rezervasyon durumu boş bırakılamaz!")
    private String status;

    @NotNull(message = "Customer ID boş bırakılamaz!")
    private Long customerId;

    @NotNull(message = "Room ID boş bırakılamaz!")
    private Long roomId;
}
