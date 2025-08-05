package com.hakan.otel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;

    private String type; //Örn. tek kişilik, çift kişilik.

    private String description;

    private int capacity;

    private double price;

    private String imagePath; //Görsel dosya yolu URL
}
