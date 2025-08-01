package com.example.gestionconge.dtos;

import com.example.gestionconge.entities.Enumm.StatutDemande;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class ValidationDemandeCongeDTO {
    @NotNull
    private Long idValidation;

    @NotNull
    private LocalDate dateValidation;

    @NotEmpty(message = "statutDemande est requis")
    private StatutDemande statut;

    private Long managerId;
}

