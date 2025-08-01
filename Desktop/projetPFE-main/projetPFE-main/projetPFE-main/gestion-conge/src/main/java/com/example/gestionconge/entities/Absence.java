package com.example.gestionconge.entities;

import com.example.gestionconge.entities.Enumm.StatutConge;
import com.example.gestionconge.entities.Enumm.typeAbsence;
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

public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbsence;

    private Date dateDebut;
    private Date dateFin;

    private Long nombreJours;

    @Enumerated(EnumType.STRING)
    private typeAbsence type;

    private String commentaire;

    private String justificatif;

    @Enumerated(EnumType.STRING)
    private StatutConge statutConge;
}

