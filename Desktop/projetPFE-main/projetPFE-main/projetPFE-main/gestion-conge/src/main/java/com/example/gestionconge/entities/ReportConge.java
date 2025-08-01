package com.example.gestionconge.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReportConge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReport;

    @ManyToOne
    private Utilisateur utilisateur;

    private Integer joursReportes;
    private Integer anneeOrigine;
}