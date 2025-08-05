package com.hakan.otel.dto.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerAdminDTO {

    private Long id;

    @NotBlank(message = "İsim boş bırakılamaz!")
    private String firstName;

    @NotBlank(message = "Soyisim boş bırakılamaz!")
    private String lastName;

    @Email(message = "Geçerli bir email adresi giriniz!")
    private String email;

    @Pattern(regexp = "^(\\+90|0)?5\\d{9}$", message = "Geçerli telefon numarası giriniz!")
    private String phone;

    @Pattern(regexp = "^[1-9][0-9]{10}$", message = "Geçerli bir TCKN giriniz!")
    private String tckn;
}
