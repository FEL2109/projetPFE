package com.example.gestionconge.dtos;

import com.example.gestionconge.entities.Enumm.StatutConge;
import com.example.gestionconge.entities.Enumm.StatutDemande;
import com.example.gestionconge.entities.Enumm.typeAbsence;
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

public class AbsenceDTO {

    private Long idAbsence;

    @NotNull
    private LocalDate dateDebut;

    @NotNull
    private LocalDate dateFin;

    private Long nombreJours;


    @NotEmpty(message = "typeAbsence est requis")
    private typeAbsence type;

    private String commentaire;

    private String justificatif;

    private StatutConge statutConge;

}

