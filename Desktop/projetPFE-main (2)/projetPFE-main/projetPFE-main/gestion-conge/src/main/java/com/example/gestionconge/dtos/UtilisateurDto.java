package com.example.gestionconge.dtos;

import lombok.*;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
@ToString
@Builder

public class UtilisateurDto {
    private Long id;

    private String username;
    private String password;

    private String nom;
    private String prenom;
    private String email;
    private String role;
    private String motDePasse;
    private String telephone;
    private String cheminPhoto;
}
