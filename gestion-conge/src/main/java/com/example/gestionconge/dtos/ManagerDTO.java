package com.example.gestionconge.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
@ToString
@Builder

public class ManagerDTO {


    @NotEmpty(message = "nom est requis")
    private String nom;

    @NotEmpty(message = "prenom est requis")
    private String prenom;

    @NotEmpty(message = "email est requis")
    private String email;

    @NotEmpty(message = "telephone est requis")
    private String telephone;

    @NotNull
    private String cheminPhoto;
}


