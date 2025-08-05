package com.hakan.otel.entity;

import com.hakan.otel.service.CustomerService.CustomerService;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "İsim boş bırakılamaz!")
    @Size(max = 20, message = "İsim 20 karakterden uzun olamaz!")
    private String firstName;

    @NotBlank(message = "Soyisim boş bırakılamaz!")
    @Size(max = 20, message = "Soyisim 20 karakterden uzun olamaz!")
    private String lastName;

    @NotBlank(message = "email kısmı boş bırakılamaz!")
    @Email(message = "email kısmı doğru girilmelidir!")
    private String email;

    @Pattern(regexp = "^(\\+90)?\\d{10}$", message = "Geçerli bir telefon numarası girilmelidir!")
    private String phone;

    @NotBlank(message = "TCKN boş bırakılamaz!")
    @Pattern(regexp = "\\d{11}", message = "TCKN must be 11 digits")
    private String tckn;
}
