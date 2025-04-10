package com.example.gestionconge.dtos;

import com.example.gestionconge.entities.Enumm.StatutDemande;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class DemandeCongeDTO {
    @NotNull
    private Long idDemande;

    @NotNull
    private LocalDate dateDebut;

    @NotNull
    private LocalDate dateDemande;

    @NotNull
    private int nombreJours;

    @NotEmpty(message = "statutDemande est requis")
    private StatutDemande statut;

    @NotEmpty(message = "commentaire est requis")
    private String commentaire;

    private Long employeId;
    private Long managerId;
    private Long typeCongeId;
    private Long regleCongeId;
}



