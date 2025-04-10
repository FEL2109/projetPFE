package com.example.gestionconge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class Employe  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String telephone;
    private String cheminPhoto;
    private String poste;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<DemandeConge> demandesConge = new ArrayList<>();

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Absence> absences;

    @OneToOne(mappedBy = "employe", cascade = CascadeType.ALL, orphanRemoval = true)
    private SoldeConge soldeConge;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;
}
