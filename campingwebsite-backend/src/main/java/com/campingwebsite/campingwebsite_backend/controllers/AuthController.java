package com.campingwebsite.campingwebsite_backend.controllers;


import com.campingwebsite.campingwebsite_backend.dtos.AuthRequest;
import com.campingwebsite.campingwebsite_backend.dtos.AuthResponse;
import com.campingwebsite.campingwebsite_backend.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.campingwebsite.campingwebsite_backend.repositories.UtilisateurRepository;
import com.campingwebsite.campingwebsite_backend.security.JwtUtil;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired private UtilisateurRepository utilisateurRepo;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
//        Utilisateur user = utilisateurRepo.findByUsername(request.getUsername());
        Utilisateur user =utilisateurRepo.findByUsername(request.getUsername());

        if (user != null && user.getPassword().equals(request.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(new AuthResponse(token, user.getRole()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
