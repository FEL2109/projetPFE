package com.example.gestionconge.entities;

import com.example.gestionconge.entities.Enumm.StatutDemande;
import com.example.gestionconge.entities.Enumm.TypeDeConge;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DemandeConge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDemande;

    private Date dateDebut;
    private Date dateFin;
    private Integer soldeannuel = 30;
    private Integer congepris;
    private Integer congerestant;

    @Enumerated(EnumType.STRING)
    private TypeDeConge typeConge;

    @Enumerated(EnumType.STRING)
    private StatutDemande statut;

    private String commentaire;
    private String justificatif;

    @ManyToOne
    private Utilisateur utilisateur;

}

