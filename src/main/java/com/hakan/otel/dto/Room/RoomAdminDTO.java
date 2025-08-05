package com.hakan.otel.dto.Room;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomAdminDTO {

    private Long id;

    @NotBlank(message = "Oda adı boş olamaz")
    @Size(min = 2, max = 50, message = "Oda adı 2 ile 50 karakter arasında olmalıdır")
    private String roomName;

    @NotBlank(message = "Oda tipi boş olamaz")
    @Size(min = 2, max = 30, message = "Oda tipi 2 ile 30 karakter arasında olmalıdır")
    private String type;

    @Min(value = 1, message = "Kapasite en az 1 olmalıdır")
    private int capacity;

    @DecimalMin(value = "0.0", inclusive = false, message = "Fiyat 0'dan büyük olmalıdır")
    private double price;

    @Size(max = 500, message = "Açıklama en fazla 500 karakter olabilir")
    private String description;

    @Size(max = 255, message = "Görsel yolu en fazla 255 karakter olabilir")
    private String imagePath;
}
