package com.example.gestionconge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class SoldeConge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolde;

    private LocalDate annee;
    private Long joursRestants;


    @OneToOne
    @JoinColumn(name = "employe_id", nullable = false, unique = true)
    private Employe employe;
}
