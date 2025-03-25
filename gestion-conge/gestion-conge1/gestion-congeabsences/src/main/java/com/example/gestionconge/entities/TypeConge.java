package com.example.gestionconge.entities;

import com.example.gestionconge.entities.Enumm.typeCongeLibelle;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class TypeConge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeConge;

    private typeCongeLibelle libelle;
    private String description;
    private int nombreJours;

    @ManyToOne
    @JoinColumn(name = "regle_conge_id", nullable = false)
    private RegleConge regleConge;
}
