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
    private Long idmanager;
    private String nom;
    private String prenom;
    private String email;
    private String motdepasse;
    private String telephone;
    private String cheminphoto;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<DemandeConge> demandesGerees = new ArrayList<>();

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<ValidationDemandeConge> validations;
}
