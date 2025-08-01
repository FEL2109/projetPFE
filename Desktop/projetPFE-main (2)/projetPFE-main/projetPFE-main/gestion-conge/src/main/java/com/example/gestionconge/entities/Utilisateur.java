package com.example.gestionconge.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;
    private String password;

    private String nom;
    private String prenom;
    private String email;
    private String role;
    private String telephone;
    private String cheminPhoto;


    public Utilisateur(Long employeId) {
        this.id = employeId;

    }
}
