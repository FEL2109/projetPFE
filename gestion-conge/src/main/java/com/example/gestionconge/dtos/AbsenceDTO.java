package com.example.gestionconge.dtos;

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
    @NotNull
    private Long idAbsence;

    @NotNull
    private LocalDate dateDebut;

    @NotNull
    private LocalDate dateFin;

    @NotEmpty(message = "typeAbsence est requis")
    private typeAbsence type;

    @NotEmpty(message = "motifAbsence est requis")
    private String motif;

    @NotNull
    private Long employeId;
}

