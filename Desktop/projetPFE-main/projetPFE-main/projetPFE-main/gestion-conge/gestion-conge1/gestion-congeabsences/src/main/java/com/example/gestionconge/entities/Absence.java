package com.example.gestionconge.entities;

import com.example.gestionconge.entities.Enumm.typeAbsence;
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

public class Absence {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbsence;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private typeAbsence type;

    private String Motif;


    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;
}

