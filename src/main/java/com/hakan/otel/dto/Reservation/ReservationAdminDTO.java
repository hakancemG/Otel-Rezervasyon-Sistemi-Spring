package com.hakan.otel.dto.Reservation;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationAdminDTO {

    private Long id;

    @NotNull(message = "Başlangıç tarihi boş olamaz!")
    @FutureOrPresent(message = "Başlangıç tarihi bugünden büyük olamaz!")
    private LocalDate startDate;

    @NotNull(message = "Bitiş tarihi boş olamaz!")
    private LocalDate endDate;

    @NotBlank(message = "Rezervasyon durumu boş bırakılamaz!")
    @Size(min = 8, max = 10, message = "Durum en az 8 en çok 10 karakter olmalıdır!")
    private String status;

    @NotNull(message="Toplam fiyat boş bırakılamaz!")
    @Positive(message = "Toplam fiyat pozitif bir değer olmalıdır!")
    private Double totalPrice;

    @NotNull(message = "Customer ID boş olamaz")
    private Long customerId;

    @NotNull(message = "Room ID boş olamaz")
    private Long roomId;
}
