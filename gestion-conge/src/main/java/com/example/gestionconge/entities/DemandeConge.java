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

    private LocalDate dateFin;

    private int nombreJours;

    @Enumerated(EnumType.STRING)
    private StatutDemande statut;

    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;



}

