package com.example.gestionconge.entities;

import com.example.gestionconge.entities.Enumm.StatutDemande;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class DemandeConge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDemande;

    private LocalDate dateDebut;

    private LocalDate dateDemande;

    private int nombreJours;

    @Enumerated(EnumType.STRING)
    private StatutDemande statut;

    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "type_conge_id", nullable = false)
    private TypeConge typeConge;

    @ManyToOne
    @JoinColumn(name = "regle_conge_id", nullable = false)
    private RegleConge regleConge;

}

