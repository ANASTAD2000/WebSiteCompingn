package com.campingwebsite.campingwebsite_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Utilisateur {
//    @OneToMany(mappedBy = "client")
//    private List<Reservation> reservations;



}
