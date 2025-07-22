package com.campingwebsite.campingwebsite_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guide extends Utilisateur{
    private String telephone;
    private String whatsapp;
    private String email;
    @ManyToMany
    @JoinTable(
            name = "guide_zone",
            joinColumns = @JoinColumn(name = "guide_id"),
            inverseJoinColumns = @JoinColumn(name = "zone_id")
    )
    private List<ZoneCamping> zones;

    @OneToMany(mappedBy = "guide")
    private List<Reservation> reservations;


}
