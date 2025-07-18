package com.example.gestionconge.dtos;

import com.example.gestionconge.entities.Enumm.StatutDemande;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DemandeCongeDTO {

    private Long idDemande;

    @NotNull(message = "La date de début est requise")
    private LocalDate dateDebut;

    @NotNull(message = "La date de demande est requise")
    private LocalDate dateDemande;

    @NotNull(message = "Le nombre de jours est requis")
    private Integer nombreJours;

    @NotNull(message = "Le statut est requis")
    private StatutDemande statut;

    @NotBlank(message = "Le commentaire est requis")
    private String commentaire;

    private Long employeId;



}
