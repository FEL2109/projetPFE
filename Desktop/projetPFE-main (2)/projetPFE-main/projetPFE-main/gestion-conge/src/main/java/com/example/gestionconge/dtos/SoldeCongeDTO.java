package com.example.gestionconge.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class SoldeCongeDTO {
    @NotNull
    private Long idSolde;

    @NotNull
    private LocalDate annee;

    private Long joursRestants;

    private Long employeId;
}


