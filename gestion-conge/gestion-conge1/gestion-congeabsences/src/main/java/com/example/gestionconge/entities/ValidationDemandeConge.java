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

public class ValidationDemandeConge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idValidation;
    private LocalDate dateValidation;

    @Enumerated(EnumType.STRING)
    private StatutDemande statut;


    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;
}
