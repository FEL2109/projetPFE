package com.example.gestionconge.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class RegleCongeDTO {
    @NotNull
    private Long idRegle;

    @NotEmpty(message = "le typeConge est requis")
    private String typeConge;

    @NotNull
    private int joursAnnuels;
}

