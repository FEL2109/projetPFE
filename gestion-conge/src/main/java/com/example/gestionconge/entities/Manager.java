package com.example.gestionconge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
@ToString
@Builder

public class Manager {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManager;

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String telephone;
    private String cheminPhoto;



    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<ValidationDemandeConge> validations;
}
