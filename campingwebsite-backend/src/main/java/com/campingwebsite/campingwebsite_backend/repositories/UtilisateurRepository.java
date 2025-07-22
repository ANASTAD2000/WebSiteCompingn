package com.campingwebsite.campingwebsite_backend.repositories;

import com.campingwebsite.campingwebsite_backend.models.Utilisateur;

import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
    Utilisateur findByUsername(String username);
}
