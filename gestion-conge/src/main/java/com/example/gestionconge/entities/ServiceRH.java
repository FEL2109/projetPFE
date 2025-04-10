package com.example.gestionconge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class ServiceRH  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRH;

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String telephone;
    private String cheminPhoto;
}
