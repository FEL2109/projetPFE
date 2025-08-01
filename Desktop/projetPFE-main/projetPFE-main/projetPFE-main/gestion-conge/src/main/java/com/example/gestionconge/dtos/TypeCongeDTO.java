package com.example.gestionconge.dtos;

import com.example.gestionconge.entities.Enumm.typeCongeLibelle;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class TypeCongeDTO {
    @NotNull
    private Long idTypeConge;

    @NotEmpty(message = "libelle est requis")
    private typeCongeLibelle libelle;

    @NotEmpty(message = "description est requis")
    private String description;

    @NotNull
    private int nombreJours;

    private Long regleCongeId;
}

