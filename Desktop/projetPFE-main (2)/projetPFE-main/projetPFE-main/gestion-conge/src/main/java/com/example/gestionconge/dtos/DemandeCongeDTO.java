package com.example.gestionconge.dtos;

import com.example.gestionconge.entities.Enumm.StatutDemande;
import com.example.gestionconge.entities.Enumm.TypeDeConge;
import com.example.gestionconge.entities.Utilisateur;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DemandeCongeDTO {

    private Long idDemande;

    @NotNull(message = "La date de début est requise")
    private Date dateDebut;

    @NotNull(message = "La date de demande est requise")
    private Date dateFin;

    private Integer soldeannuel = 30;
    private Integer congepris;
    private Integer congerestant;

    @NotNull(message = "Le statut est requis")
    private StatutDemande statut;

    private TypeDeConge typeConge;

    @NotBlank(message = "Le commentaire est requis")
    private String commentaire;

    private String justificatif;
    private Utilisateur utilisateur;

}
