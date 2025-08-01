package com.example.gestionconge.dtos;

import com.example.gestionconge.entities.Utilisateur;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CongeReportDTO {
    private Long idReport;

    private Utilisateur utilisateur;

    private Integer joursReportes;
    private Integer anneeOrigine;
}
