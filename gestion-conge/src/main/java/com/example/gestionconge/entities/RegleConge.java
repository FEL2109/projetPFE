package com.example.gestionconge.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class RegleConge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRegle;

    private String typeConge;
    private int joursAnnuels;


}
