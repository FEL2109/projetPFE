package com.example.gestionconge.dtos;

import com.example.gestionconge.entities.Absence;
import com.example.gestionconge.entities.DemandeConge;
import com.example.gestionconge.entities.Notification;
import com.example.gestionconge.entities.SoldeConge;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class EmployeDTO {
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
/* je garde que les information dont j ai besoin lors du consultation d emoloye
* je supprime les relation dont j ai pas besoin et @entitz
* et je cree la mapper qui me permet de transferer les donnes d un objet a un autre */