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

public class ServiceRHDTO {
    @NotNull
    private Long idRh;

    @NotEmpty(message = "nom est requis")
    private String nom;

    @NotEmpty(message = "prenom est requis")
    private String prenom;

    @NotEmpty(message = "email est requis")
    private String email;

    @NotEmpty(message = "telephone est requis")
    private String telephone;

    @NotEmpty(message = "cheminPhoto est requis")
    private String cheminPhoto;
}
