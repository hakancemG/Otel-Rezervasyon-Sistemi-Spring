package com.hakan.otel.dto.Customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "İsim boş bırakılamaz!")
    @Size(max=20, message="İsim 20 karakterden fazla olamaz!")
    private String firstName;

    @NotBlank(message = "Soyisim boş bırakılamaz!")
    @Size(max=15, message="Soyisim 15 karakterden fazla olamaz!")
    private String lastName;
}
